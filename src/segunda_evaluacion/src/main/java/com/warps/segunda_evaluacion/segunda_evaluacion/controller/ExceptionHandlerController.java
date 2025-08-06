package com.warps.segunda_evaluacion.segunda_evaluacion.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.warps.segunda_evaluacion.segunda_evaluacion.dto.ExceptionDTO;
import com.warps.segunda_evaluacion.segunda_evaluacion.exception.DatoInvalidoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.exception.RecursoNoEncontradoException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(
        {
            DatoInvalidoException.class,
            MethodArgumentTypeMismatchException.class
        }
    )
    public ResponseEntity<ExceptionDTO> datoInvalidoException(Exception e){
        ExceptionDTO response = new ExceptionDTO();
        response.setMessage(e.getMessage());
        response.setError("El dato ingresado no es válido");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setDate(new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ExceptionDTO> recursoNoEncontradoException(Exception e){
        ExceptionDTO response = new ExceptionDTO();
        response.setMessage(e.getMessage());
        response.setError("El recurso solicitado no existe");
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setDate(new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
