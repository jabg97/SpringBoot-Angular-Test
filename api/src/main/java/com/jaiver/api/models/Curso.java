/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Jaiver
 */
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grado", nullable = false)
    private Integer grado;

    @Column(name = "salon", nullable = false)
    private String salon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_colegio", nullable = false, updatable = false)
    @JsonIgnoreProperties("cursos")
    private Colegio colegio;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "curso")
    @JsonIgnore
    private List<Asignatura> asignaturas;

    public Curso() {
    }

    public Curso(Integer grado, String salon) {
        this.grado = grado;
        this.salon = salon;
    }

    public Long getId() {
        return id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public List<Asignatura> getAsignaturas() {
        if(this.asignaturas == null){
            return new ArrayList<>();
        }
        return asignaturas;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + this.id + ", grado=" + this.grado + ", salon=" + this.salon
                + ", colegio=" + ((this.colegio != null) ? this.colegio.getNombre() : "null")
                + ", asignaturas=" + ((this.asignaturas != null) ? this.asignaturas.size() : "null") + '}';
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
        Curso otro = (Curso) obj;
        return this.id != null && this.id.equals(otro.getId());
    }
}
