/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.repositories;

import com.jaiver.api.models.Asignatura;
import com.jaiver.api.models.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jaiver
 */
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
List<Asignatura> findByProfesor(Profesor profesor);
}
