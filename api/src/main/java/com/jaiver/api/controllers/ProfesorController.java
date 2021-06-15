/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Colegio;
import com.jaiver.api.models.Profesor;
import com.jaiver.api.repositories.ColegioRepository;
import com.jaiver.api.repositories.ProfesorRepository;
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
public class ProfesorController {

    @Autowired
    ProfesorRepository profesorRepository;
    
    @Autowired
    ColegioRepository colegioRepository;

    @GetMapping("/profesor-colegio/{id}")
    public ResponseEntity<List<Profesor>> getProfesorByColegio(@PathVariable("id") long id) {
        try {
Optional<Colegio> colegioData = colegioRepository.findById(id);

        if (colegioData.isPresent()) {
            List<Profesor> profesores = profesorRepository.findProfesorByColegio(colegioData.get());
            if (profesores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(profesores, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/profesor")
    public ResponseEntity<List<Profesor>> getAllProfesores() {
        try {

            List<Profesor> profesores = profesorRepository.findAll();
            if (profesores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(profesores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable("id") long id) {
        Optional<Profesor> profesorData = profesorRepository.findById(id);

        if (profesorData.isPresent()) {
            return new ResponseEntity<>(profesorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/profesor")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor request) {
        try {
            Profesor profesor = profesorRepository
                    .save(new Profesor(request.getNombre()));
            return new ResponseEntity<>(profesor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/profesor/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable("id") long id, @RequestBody Profesor request) {
        Optional<Profesor> profesorData = profesorRepository.findById(id);
        if (profesorData.isPresent()) {
            try {
                Profesor profesor = profesorData.get();
                profesor.setNombre(request.getNombre());
                return new ResponseEntity<>(profesorRepository.save(profesor), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/profesor/{id}")
    public ResponseEntity<HttpStatus> deleteProfesor(@PathVariable("id") long id) {
        try {
            profesorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
