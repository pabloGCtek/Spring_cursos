package com.example.curso.exceptions;

import java.time.LocalDateTime;

public class ExcepcionRespuesta extends Exception{

    private LocalDateTime datetime;
    private String desc;
    public ExcepcionRespuesta(LocalDateTime datetime, String errorMessage, String desc){
        super(errorMessage);
        this.datetime=datetime;
        this.desc=desc;
    }
}
