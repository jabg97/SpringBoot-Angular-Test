/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Estudiante;
import com.jaiver.api.repositories.EstudianteRepository;
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
public class EstudianteController {

    @Autowired
    EstudianteRepository estudianteRepository;

    @GetMapping("/estudiante")
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        try {

            List<Estudiante> estudiantes = estudianteRepository.findAll();
            if (estudiantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable("id") long id) {
        Optional<Estudiante> estudianteData = estudianteRepository.findById(id);

        if (estudianteData.isPresent()) {
            return new ResponseEntity<>(estudianteData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/estudiante")
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante request) {
        try {
            Estudiante estudiante = estudianteRepository
                    .save(new Estudiante(request.getNombre()));
            return new ResponseEntity<>(estudiante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/estudiante/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable("id") long id, @RequestBody Estudiante request) {
        Optional<Estudiante> estudianteData = estudianteRepository.findById(id);
        if (estudianteData.isPresent()) {
            try {
                Estudiante estudiante = estudianteData.get();
                estudiante.setNombre(request.getNombre());
                return new ResponseEntity<>(estudianteRepository.save(estudiante), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/estudiante/{id}")
    public ResponseEntity<HttpStatus> deleteEstudiante(@PathVariable("id") long id) {
        try {
            estudianteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
