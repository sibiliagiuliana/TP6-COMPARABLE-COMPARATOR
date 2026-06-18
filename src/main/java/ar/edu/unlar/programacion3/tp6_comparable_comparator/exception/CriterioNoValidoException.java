
package ar.edu.unlar.programacion3.tp6_comparable_comparator.exception;
import java.util.Set;


public class CriterioNoValidoException extends RuntimeException {

    private final String criterioRecibido;
    private final Set<String> criteriosAceptados;

    public CriterioNoValidoException(String criterioRecibido, Set<String> criteriosAceptados) {
        super("Criterio de ordenamiento no válido: " + criterioRecibido);
        this.criterioRecibido = criterioRecibido;
        this.criteriosAceptados = criteriosAceptados;
    }

    public String getCriterioRecibido() { return criterioRecibido; }
    public Set<String> getCriteriosAceptados() { return criteriosAceptados; }
}


