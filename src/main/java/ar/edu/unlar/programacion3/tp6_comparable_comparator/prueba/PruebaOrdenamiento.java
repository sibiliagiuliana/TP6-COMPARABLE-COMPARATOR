package ar.edu.unlar.programacion3.tp6_comparable_comparator.prueba;

import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.comparator.EstudianteComparators;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PruebaOrdenamiento {

    public static void main(String[] args) {
    
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("LU-2024-001", "Martín Quiroga",     22, 8.5, 18));
        estudiantes.add(new Estudiante("LU-2024-002", "Valeria Díaz",       20, 8.5, 15));   
        estudiantes.add(new Estudiante("LU-2024-003", "Facundo Castro",     24, 7.2, 22));
        estudiantes.add(new Estudiante("LU-2024-004", "Camila Torres",      21, 9.1, 24));
        estudiantes.add(new Estudiante("LU-2024-005", "Lucas González",     23, 9.1, 24));  
        estudiantes.add(new Estudiante("LU-2024-006", "Agustina López",     19, 6.8, 10));

        System.out.println("Estudiantes antes del ordenamiento:");
        estudiantes.forEach(System.out::println);
        
        Collections.sort(estudiantes);
        System.out.println("\nEstudiantes después del ordenamiento por promedio:");
        estudiantes.forEach(System.out::println);

        // Lambda explícito: ordena por cantidad de materias aprobadas ascendente
        System.out.println("\n=== POR MATERIAS APROBADAS (ASC) ===");
        estudiantes.sort(EstudianteComparators.POR_MATERIAS_ASC);
        estudiantes.forEach(System.out::println);

        // Metodo de referencia: por nombre alfabetico
        System.out.println("\n=== POR NOMBRE (ALFABETICO) ===");
        estudiantes.sort(EstudianteComparators.POR_NOMBRE);
        estudiantes.forEach(System.out::println);

        // Metodo de referencia: por edad ascendente
        System.out.println("\n=== POR EDAD (ASC) ===");
        estudiantes.sort(EstudianteComparators.POR_EDAD_ASC);
        estudiantes.forEach(System.out::println);

        // Promedio descendente con desempate por nombre ascendente
        System.out.println("\n=== POR PROMEDIO (DESC) + DESEMPATE POR NOMBRE (ASC) ===");
        estudiantes.sort(EstudianteComparators.POR_PROMEDIO_DESC_LUEGO_NOMBRE_ASC);
        estudiantes.forEach(System.out::println);

        // Revertir el orden natural (promedio descendente) por promedio ascendente
        System.out.println("\n=== POR PROMEDIO ASC (revertido) ===");
        estudiantes.sort(EstudianteComparators.POR_PROMEDIO_ASC);
        estudiantes.forEach(System.out::println);

        // Combinando comparadores: materias DESC por desempate con nombre ASC
        System.out.println("\n=== POR MATERIAS (DESC) + DESEMPATE POR NOMBRE (ASC) ===");
        estudiantes.sort(EstudianteComparators.POR_MATERIAS_DESC_LUEGO_NOMBRE_ASC);
        estudiantes.forEach(System.out::println);

        

    }


}
