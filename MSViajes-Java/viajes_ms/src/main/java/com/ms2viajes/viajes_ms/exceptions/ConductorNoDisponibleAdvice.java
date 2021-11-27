package com.ms2viajes.viajes_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class ConductorNoDisponibleAdvice {
    @ResponseBody
    @ExceptionHandler(ConductorNoDisponibleException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(ConductorNoDisponibleException ex){

        return ex.getMessage();
    }
}
