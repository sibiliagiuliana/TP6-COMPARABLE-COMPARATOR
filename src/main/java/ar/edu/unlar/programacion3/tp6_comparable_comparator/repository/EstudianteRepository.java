package ar.edu.unlar.programacion3.tp6_comparable_comparator.repository;
  import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class EstudianteRepository {


    private final List<Estudiante> estudiantes = new ArrayList<>();

    // @PostConstruct se ejecuta automáticamente cuando Spring
    // termina de crear el bean, ideal para cargar datos iniciales
    @PostConstruct
    public void init() {
        estudiantes.add(new Estudiante("LU-2024-001", "Martín Quiroga",   22, 22, 18));
        estudiantes.add(new Estudiante("LU-2024-002", "Valeria Díaz",     20, 8.5, 15));
        estudiantes.add(new Estudiante("LU-2024-003", "Facundo Castro",   24, 7.2, 22));
        estudiantes.add(new Estudiante("LU-2024-004", "Camila Torres",    21, 9.1, 24));
        estudiantes.add(new Estudiante("LU-2024-005", "Lucas González",   23, 9.1, 24));
        estudiantes.add(new Estudiante("LU-2024-006", "Agustina López",   19, 6.8, 10));
        estudiantes.add(new Estudiante("LU-2024-007", "Nahuel Herrera",   22, 7.5, 14));
        estudiantes.add(new Estudiante("LU-2024-008", "Florencia Ríos",   25, 8.9, 20));
        estudiantes.add(new Estudiante("LU-2024-009", "Tomás Sosa",       20, 6.5, 12));
        estudiantes.add(new Estudiante("LU-2024-010", "Lucía Fernández",  21, 7.8, 16));
    }

    public List<Estudiante> findAll() {
        // Devolvemos una copia defensiva para que nadie modifique
        // la lista original desde afuera del repositorio
        return new ArrayList<>(estudiantes);
    }
}


