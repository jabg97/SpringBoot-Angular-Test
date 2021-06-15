/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.repositories;

import com.jaiver.api.models.Colegio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jaiver
 */
public interface ColegioRepository extends JpaRepository<Colegio, Long> {

}
