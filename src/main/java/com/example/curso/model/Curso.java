package com.example.curso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    public int idCurso;
    private String nombre;
    private int duracion;
    private int idProfesor;
}
