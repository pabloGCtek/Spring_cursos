package com.example.curso.repository;

import com.example.curso.exceptions.ExceptionNoEncontrado;
import com.example.curso.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoRepo implements ICursoRepo{
    private List<Curso> cursos;
    @Override
    public List<Curso> consultarTodos() {
        return cursos;
    }

    @Override
    public Curso consultarUno(int id) {
        Curso curso = this.cursos.stream()
                .filter( c -> c.getIdCurso() == id)
                .findFirst()
                .orElse(null);
        return curso;
    }

    @Override
    public Curso crear(Curso curso) {
        cursos.add(curso);
        return curso;
    }

    @Override
    public Curso modificar(Curso curso) {
        Curso curso2 = this.cursos.stream()
                .filter( c -> c.getIdCurso() == curso.getIdCurso())
                .findFirst()
                .orElse(null);
        if(curso2 == null){
            try {
                throw new ExceptionNoEncontrado();
            } catch (ExceptionNoEncontrado e) {
                throw new RuntimeException(e);
            }
        }else{
            eliminar(curso2.getIdCurso());
            crear(curso2);
        }
        return curso2;
    }

    @Override
    public void eliminar(int id) {
        this.cursos.removeIf(c -> c.getIdCurso() == id);
    }
}
