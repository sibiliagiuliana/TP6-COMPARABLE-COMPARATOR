package ar.edu.unlar.programacion3.tp6_comparable_comparator.comparator;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import java.util.Comparator;

public class EstudianteComparators {

    // Lambda explicito: ordena por cantidad de materias ascendente
    public static final Comparator<Estudiante> POR_MATERIAS_ASC = 
            (e1, e2) -> Integer.compare(e1.getMateriasAprobadas(), e2.getMateriasAprobadas());

    // Comparator.comparing + referencia de metodo: ordena por nombre alfabetico y edad asc
    public static final Comparator<Estudiante> POR_NOMBRE=
            Comparator.comparing(Estudiante::getNombre);

    public static final Comparator<Estudiante> POR_EDAD_ASC =
            Comparator.comparingInt(Estudiante::getEdad);


    // Desempate: promedio descendente por nombre asc
    public static final Comparator<Estudiante> POR_PROMEDIO_DESC_LUEGO_NOMBRE_ASC =
            Comparator.comparingDouble(Estudiante::getPromedio)
            .reversed()
            .thenComparing(Estudiante::getNombre);

    // Revertir el orden natural (promedio descendente) por promedio ascendente
    public static final Comparator<Estudiante> POR_PROMEDIO_ASC =
            Comparator.comparingDouble(Estudiante::getPromedio)
            .reversed() // DESCENDENTE
            .reversed(); // ASCENDENTE

    // Combinando comparadores: materias DESC por desempate con nombre ASC
    public static final Comparator<Estudiante> POR_MATERIAS_DESC_LUEGO_NOMBRE_ASC =
            Comparator.comparingInt(Estudiante::getMateriasAprobadas)
            .reversed() // DESCENDENTE
            .thenComparing(Estudiante::getNombre); // NOMBRE ASC

        
        
        
        }
