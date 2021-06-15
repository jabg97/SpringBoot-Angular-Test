/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Curso;
import com.jaiver.api.repositories.CursoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaiver
 */
@RestController
@RequestMapping("/api/v1")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping("/curso")
    public ResponseEntity<List<Curso>> getAllCursos() {
        try {

            List<Curso> cursos = cursoRepository.findAll();
            if (cursos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cursos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") long id) {
        Optional<Curso> cursoData = cursoRepository.findById(id);

        if (cursoData.isPresent()) {
            return new ResponseEntity<>(cursoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/curso")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso request) {
        try {
            Curso curso = new Curso(request.getGrado(), request.getSalon());
            cursoRepository.save(curso);
            return new ResponseEntity<>(curso, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable("id") long id, @RequestBody Curso request) {
        Optional<Curso> cursoData = cursoRepository.findById(id);
        if (cursoData.isPresent()) {
            try {
                Curso curso = cursoData.get();
                curso.setGrado(request.getGrado());
                curso.setSalon(request.getSalon());
                return new ResponseEntity<>(cursoRepository.save(curso), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<HttpStatus> deleteCurso(@PathVariable("id") long id) {
        try {
            cursoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
