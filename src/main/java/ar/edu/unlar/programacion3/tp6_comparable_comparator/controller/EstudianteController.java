package ar.edu.unlar.programacion3.tp6_comparable_comparator.controller;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.service.EstudianteService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> getEstudiantes(
            @RequestParam(defaultValue = "promedio") String sortBy,
            @RequestParam(defaultValue = "asc")     String order) {

        // El controller ahora solo delega. Sin if-else, sin comparators.
        return service.ordenar(sortBy, order);
    }
}




