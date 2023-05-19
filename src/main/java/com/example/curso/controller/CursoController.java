package com.example.curso.controller;


import com.example.curso.model.Curso;
import com.example.curso.service.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cursos")
public class CursoController {
@Autowired
    private ICursoServicio servicio;

    @GetMapping
        public ResponseEntity<List<Curso>> consultarTodos(){
        return new ResponseEntity<>(servicio.consultarTodos(), HttpStatus.OK);
    }
    /*
    @GetMapping
    public ResponseEntity<Curso> consultarUno(@PathVariable("id")int id){
        return new ResponseEntity<>(servicio.consultarUno(id), HttpStatus.OK);
    }*/
    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso){
        System.out.println(curso.toString());
        return new ResponseEntity<>(servicio.crear(curso), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Curso> modificar(@RequestBody Curso curso){
        System.out.println(curso.toString());
        return new ResponseEntity<>(servicio.modificar(curso),HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public void modificar(@PathVariable("id") int id){
        Curso resultadoBBDD = servicio.consultarUno(id);
        if(resultadoBBDD == null){
            System.out.println("No encontrado");
        }else{
            servicio.eliminar(id);
        }
    }

}
