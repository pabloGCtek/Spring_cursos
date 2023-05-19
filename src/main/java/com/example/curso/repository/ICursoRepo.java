package com.example.curso.repository;

import com.example.curso.model.Curso;

import java.util.List;

public interface ICursoRepo {
    List<Curso> consultarTodos();

    Curso consultarUno(int id);

    Curso crear(Curso curso);

    Curso modificar(Curso curso);

    void eliminar(int id);
}
