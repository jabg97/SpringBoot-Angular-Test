/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Asignatura;
import com.jaiver.api.models.Profesor;
import com.jaiver.api.repositories.AsignaturaRepository;
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
public class AsignaturaController {

    @Autowired
    AsignaturaRepository asignaturaRepository;
@Autowired
    ProfesorRepository profesorRepository;

    @GetMapping("/asignatura-profesor/{id}")
    public ResponseEntity<List<Asignatura>> getAsignaturaByProfesor(@PathVariable("id") long id) {
        try {
Optional<Profesor> profesorData = profesorRepository.findById(id);

        if (profesorData.isPresent()) {
            List<Asignatura> asignaturas = asignaturaRepository.findByProfesor(profesorData.get());
            if (asignaturas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(asignaturas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asignatura")
    public ResponseEntity<List<Asignatura>> getAllAsignaturas() {
        try {
            List<Asignatura> asignaturas = asignaturaRepository.findAll();
            if (asignaturas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(asignaturas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asignatura/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable("id") long id) {
        Optional<Asignatura> asignaturaData = asignaturaRepository.findById(id);

        if (asignaturaData.isPresent()) {
            return new ResponseEntity<>(asignaturaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/asignatura")
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura request) {
        try {
            Asignatura asignatura = asignaturaRepository
                    .save(new Asignatura(request.getNombre()));
            return new ResponseEntity<>(asignatura, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/asignatura/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable("id") long id, @RequestBody Asignatura request) {
        Optional<Asignatura> asignaturaData = asignaturaRepository.findById(id);
        if (asignaturaData.isPresent()) {
            try {
                Asignatura asignatura = asignaturaData.get();
                asignatura.setNombre(request.getNombre());
                return new ResponseEntity<>(asignaturaRepository.save(asignatura), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/asignatura/{id}")
    public ResponseEntity<HttpStatus> deleteAsignatura(@PathVariable("id") long id) {
        try {
            asignaturaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
