package ar.edu.unlar.programacion3.tp6_comparable_comparator.prueba;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class AntiPatronResta {
    public static void main(String[] args) {

        System.out.println("=== DEMOSTRACIÓN DEL BUG DE OVERFLOW ===\n");
        System.out.println("\n=== EFECTO EN ORDENAMIENTO CON EDADES NORMALES ===\n");

        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("LU-001", "Camila Torres",   21, 9.1, 24));
        lista.add(new Estudiante("LU-002", "Lucas González",  23, 9.1, 24));
        lista.add(new Estudiante("LU-003", "Agustina López",  19, 6.8, 10));
        lista.add(new Estudiante("LU-004", "Martín Quiroga",  22, 8.5, 18));

        // funciona con estos valores
        lista.sort((e1, e2) -> e1.getEdad() - e2.getEdad());
        System.out.println("Con resta (parece funcionar con valores chicos):");
        lista.forEach(System.out::println);

        // Forma correcta
        lista.sort((e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad()));
        System.out.println("\nCon Integer.compare (siempre correcto):");
        lista.forEach(System.out::println);

    }
}


