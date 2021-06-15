/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.repositories;

import com.jaiver.api.models.Colegio;
import com.jaiver.api.models.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Jaiver
 */
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    
    @Query("SELECT DISTINCT pro FROM Profesor pro"
            + " INNER JOIN pro.asignaturas asg"
            + " INNER JOIN asg.curso cur"
            + " INNER JOIN cur.colegio col"
            + " WHERE col.id = :#{#colegio.id}"
            )
List<Profesor> findProfesorByColegio(@Param("colegio") Colegio colegio);
}
