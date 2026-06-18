package ar.edu.unlar.programacion3.tp6_comparable_comparator.service;

import ar.edu.unlar.programacion3.tp6_comparable_comparator.exception.CriterioNoValidoException;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;
    private final Map<String, Comparator<Estudiante>> comparators = Map.of(
        "promedio",          Comparator.comparingDouble(Estudiante::getPromedio),
        "edad",              Comparator.comparingInt(Estudiante::getEdad),
        "nombre",            Comparator.comparing(Estudiante::getNombre),
        "materiasAprobadas", Comparator.comparingInt(Estudiante::getMateriasAprobadas),
        "legajo",            Comparator.comparing(Estudiante::getLegajo)
    );

    
    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> ordenar(String sortBy, String order) {
       
        Comparator<Estudiante> comparatorBase = comparators.get(sortBy);

        if (comparatorBase == null) {
            throw new CriterioNoValidoException(sortBy, comparators.keySet());
        }

        if ("desc".equals(order)) {
            comparatorBase = comparatorBase.reversed();
        }

        Comparator<Estudiante> comparatorFinal =
                comparatorBase.thenComparing(Estudiante::getLegajo);

        List<Estudiante> lista = repository.findAll();
        lista.sort(comparatorFinal);
        return lista;
    }

    public List<String> getCriteriosAceptados() {
        return new ArrayList<>(comparators.keySet());
    }
}


