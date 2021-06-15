/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Colegio;
import com.jaiver.api.repositories.ColegioRepository;
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
public class ColegioController {

    @Autowired
    ColegioRepository colegioRepository;

    @GetMapping("/colegio")
    public ResponseEntity<List<Colegio>> getAllColegios() {
        try {
            List<Colegio> colegios = colegioRepository.findAll();
            if (colegios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(colegios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/colegio/{id}")
    public ResponseEntity<Colegio> getColegioById(@PathVariable("id") long id) {
        Optional<Colegio> colegioData = colegioRepository.findById(id);

        if (colegioData.isPresent()) {
            return new ResponseEntity<>(colegioData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/colegio")
    public ResponseEntity<Colegio> createColegio(@RequestBody Colegio request) {
        try {
            Colegio colegio = colegioRepository
                    .save(new Colegio(request.getNombre()));
            return new ResponseEntity<>(colegio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/colegio/{id}")
    public ResponseEntity<Colegio> updateColegio(@PathVariable("id") long id, @RequestBody Colegio request) {
        Optional<Colegio> colegioData = colegioRepository.findById(id);
        if (colegioData.isPresent()) {
            try {
                Colegio colegio = colegioData.get();
                colegio.setNombre(request.getNombre());
                return new ResponseEntity<>(colegioRepository.save(colegio), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/colegio/{id}")
    public ResponseEntity<HttpStatus> deleteColegio(@PathVariable("id") long id) {
        try {
            colegioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
