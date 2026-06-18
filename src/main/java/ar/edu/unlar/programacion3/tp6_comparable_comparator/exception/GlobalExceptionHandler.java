package ar.edu.unlar.programacion3.tp6_comparable_comparator.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ar.edu.unlar.programacion3.tp6_comparable_comparator.dto.ErrorResponse;

@RestControllerAdvice

public class GlobalExceptionHandler {


    @ExceptionHandler(CriterioNoValidoException.class)
    public ResponseEntity<ErrorResponse> handleCriterioNoValido(CriterioNoValidoException ex) {

        List<String> criteriosOrdenados = new ArrayList<>(ex.getCriteriosAceptados());
        Collections.sort(criteriosOrdenados);

        ErrorResponse body = new ErrorResponse(
            "Criterio de ordenamiento no válido",   // mensaje fijo
            ex.getCriterioRecibido(),               // lo que mandó el cliente
            criteriosOrdenados                      // lo que sí se acepta
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)     // 400
                .body(body);
    }
}

