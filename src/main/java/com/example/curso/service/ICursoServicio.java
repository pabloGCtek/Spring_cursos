package com.example.curso.service;

import com.example.curso.model.Curso;

import java.util.List;

public interface ICursoServicio {
    List<Curso> consultarTodos();

    Curso consultarUno(int id);

    Curso modificar(Curso curso);

    void eliminar(int id);

    Curso crear(Curso curso);

}
