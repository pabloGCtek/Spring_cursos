package com.example.curso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class interceptadorErrores  extends ResponseEntityExceptionHandler {

    public final ResponseEntity<ExcepcionRespuesta> manejadorTodasExc(Exception ex, WebRequest request){
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExceptionNoEncontrado.class)
    public final ResponseEntity<ExcepcionRespuesta> manejadorExcepcionNoEncontrado(ExceptionNoEncontrado ex, WebRequest request){
        ExcepcionRespuesta excepcion = new ExcepcionRespuesta(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
    }

}
