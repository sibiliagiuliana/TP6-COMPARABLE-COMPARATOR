package ar.edu.unlar.programacion3.tp6_comparable_comparator.dto;

import java.util.List;

public class ErrorResponse {

    private String error;
    private String criterioRecibido;
    private List<String> criteriosAceptados;

    public ErrorResponse(String error, String criterioRecibido, List<String> criteriosAceptados) {
        this.error = error;
        this.criterioRecibido = criterioRecibido;
        this.criteriosAceptados = criteriosAceptados;
    }

    public String getError() { return error; }
    public String getCriterioRecibido() { return criterioRecibido; }
    public List<String> getCriteriosAceptados() { return criteriosAceptados; }
}


