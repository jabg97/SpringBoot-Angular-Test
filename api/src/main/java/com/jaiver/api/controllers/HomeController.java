/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.controllers;

import com.jaiver.api.models.Colegio;
import com.jaiver.api.repositories.ColegioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaiver
 */
@RestController
public class HomeController {

    @Autowired
    ColegioRepository colegioRepository;

    @GetMapping("/")
    public ResponseEntity<String> getAllColegios() {
        try {
            Optional<Colegio> colegioData = colegioRepository.findById(1l);

            if (colegioData.isPresent()) {
                return new ResponseEntity<>("Welcome to \""
                        + colegioData.get().getNombre() + "\"", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
