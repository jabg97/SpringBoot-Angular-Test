/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jaiver
 */
@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso", nullable = false, updatable = false)
    @JsonIgnoreProperties({"asignaturas", "colegio"})
    private Curso curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profesor", nullable = false, updatable = false)
    private Profesor profesor;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("asignaturas")
    @JoinTable(name = "asignaturas_estudiantes",
            joinColumns = {
                @JoinColumn(name = "asignatura_id", referencedColumnName = "id",
                        nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "estudiante_id", referencedColumnName = "id",
                        nullable = false, updatable = false)})
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Asignatura() {
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Estudiante> getEstudiantes() {
        if (this.estudiantes == null) {
            return new HashSet<>();
        }
        return estudiantes;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + this.id + ", nombre=" + this.nombre
                + ", curso=" + ((this.curso != null) ? this.curso.getGrado() + this.curso.getSalon() : "null")
                + ", profesor=" + ((this.profesor != null) ? this.profesor.getNombre() : "null") + '}';
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Asignatura otro = (Asignatura) obj;
        return this.id != null && this.id.equals(otro.getId());
    }
}
