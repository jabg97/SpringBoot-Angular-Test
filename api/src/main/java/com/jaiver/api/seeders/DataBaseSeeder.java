/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaiver.api.seeders;

import com.jaiver.api.models.Colegio;
import com.jaiver.api.repositories.ColegioRepository;
import com.jaiver.api.models.Curso;
import com.jaiver.api.repositories.CursoRepository;
import com.jaiver.api.models.Asignatura;
import com.jaiver.api.models.Estudiante;
import com.jaiver.api.repositories.AsignaturaRepository;
import com.jaiver.api.models.Profesor;
import com.jaiver.api.repositories.EstudianteRepository;
import com.jaiver.api.repositories.ProfesorRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jaiver
 */
@Component
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    ColegioRepository colegioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public void run(String... args) throws Exception {
        loadColegioData();
    }

    private void loadColegioData() {
        if (colegioRepository.count() == 0) {
            /*=======================[COLEGIO]======================*/
            Colegio colegio = new Colegio("El colegio del Olimpo");
            colegioRepository.save(colegio);

            /*=======================[PROFESORES]======================*/
            Profesor nemesis = new Profesor("Némesis");
            profesorRepository.save(nemesis);
            Profesor priapo = new Profesor("Príapo");
            profesorRepository.save(priapo);
            Profesor iris = new Profesor("Iris");
            profesorRepository.save(iris);

            /*=======================[CURSO 1]======================*/
            Curso curso_10a = new Curso(10, "A");
            curso_10a.setColegio(colegio);
            cursoRepository.save(curso_10a);
            /*=======================[ASIGNATURAS]==================*/
            Asignatura matematica_10a = new Asignatura("Matemáticas");
            matematica_10a.setCurso(curso_10a);
            matematica_10a.setProfesor(nemesis);
            asignaturaRepository.save(matematica_10a);
            /*------------------------------------------------------*/
            Asignatura espanol_10a = new Asignatura("Español");
            espanol_10a.setCurso(curso_10a);
            espanol_10a.setProfesor(priapo);
            asignaturaRepository.save(espanol_10a);
            /*------------------------------------------------------*/
            Asignatura ingles_basico = new Asignatura("Ingles básico");
            ingles_basico.setCurso(curso_10a);
            ingles_basico.setProfesor(iris);
            asignaturaRepository.save(ingles_basico);
            /*=======================[ESTUDIANTE]======================*/
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            Estudiante afrodita = new Estudiante("Afrodita");
            estudianteRepository.save(afrodita);
            estudiantes.add(afrodita);
            Estudiante apolo = new Estudiante("Apolo");
            estudianteRepository.save(apolo);
            estudiantes.add(apolo);
            Estudiante ares = new Estudiante("Ares");
            estudianteRepository.save(ares);
            estudiantes.add(ares);
            /*=======================[Asignación]======================*/
            curso_10a = cursoRepository.findById(curso_10a.getId()).get();

            for (Asignatura asignatura : curso_10a.getAsignaturas()) {
                for (Estudiante estudiante : estudiantes) {
                    asignatura.getEstudiantes().add(estudiante);
                }
                asignaturaRepository.save(asignatura);
            }
            /*=======================[CURSO 2]======================*/
            Curso curso_10b = new Curso(10, "B");
            curso_10b.setColegio(colegio);
            cursoRepository.save(curso_10b);
            /*=======================[ASIGNATURAS]==================*/
            Asignatura matematica_10b = new Asignatura("Matemáticas");
            matematica_10b.setCurso(curso_10b);
            matematica_10b.setProfesor(nemesis);
            asignaturaRepository.save(matematica_10b);
            /*------------------------------------------------------*/
            Asignatura espanol_10b = new Asignatura("Español");
            espanol_10b.setCurso(curso_10b);
            espanol_10b.setProfesor(priapo);
            asignaturaRepository.save(espanol_10b);
            /*------------------------------------------------------*/
            Asignatura ingles_avanzado = new Asignatura("Ingles avanzado");
            ingles_avanzado.setCurso(curso_10b);
            ingles_avanzado.setProfesor(iris);
            asignaturaRepository.save(ingles_avanzado);
            /*=======================[ESTUDIANTE]======================*/
            estudiantes.clear();
            Estudiante artemisa = new Estudiante("Artemisa");
            estudianteRepository.save(artemisa);
            estudiantes.add(afrodita);
            Estudiante atenea = new Estudiante("Atenea");
            estudianteRepository.save(atenea);
            estudiantes.add(apolo);
            Estudiante dionisio = new Estudiante("Dionisio");
            estudianteRepository.save(dionisio);
            estudiantes.add(dionisio);
            
            /*=======================[Asignación]======================*/
            curso_10b = cursoRepository.findById(curso_10b.getId()).get();
            for (Asignatura asignatura : curso_10b.getAsignaturas()) {
                for (Estudiante estudiante : estudiantes) {
                    asignatura.getEstudiantes().add(estudiante);
                }
                asignaturaRepository.save(asignatura);
            }
            /*=======================[CURSO 3]======================*/
            Curso curso_11a = new Curso(11, "A");
            curso_11a.setColegio(colegio);
            cursoRepository.save(curso_11a);
            /*=======================[ASIGNATURAS]==================*/
            Asignatura matematica_11a = new Asignatura("Matemáticas");
            matematica_11a.setCurso(curso_11a);
            matematica_11a.setProfesor(nemesis);
            asignaturaRepository.save(matematica_11a);
            /*------------------------------------------------------*/
            Asignatura preicfes_11a = new Asignatura("Pre Icfes");
            preicfes_11a.setCurso(curso_11a);
            preicfes_11a.setProfesor(nemesis);
            asignaturaRepository.save(preicfes_11a);
            /*=======================[ESTUDIANTE]======================*/
            estudiantes.clear();
            Estudiante hefesto = new Estudiante("Hefesto");
            estudianteRepository.save(hefesto);
            estudiantes.add(hefesto);
            Estudiante hera = new Estudiante("Hera");
            estudianteRepository.save(hera);
            estudiantes.add(hera);
            
            /*=======================[Asignación]======================*/
            curso_11a = cursoRepository.findById(curso_11a.getId()).get();
            for (Asignatura asignatura : curso_11a.getAsignaturas()) {
                for (Estudiante estudiante : estudiantes) {
                    asignatura.getEstudiantes().add(estudiante);
                }
                asignaturaRepository.save(asignatura);
            }
            /*=======================[CURSO 4]======================*/
            Curso curso_11b = new Curso(11, "B");
            curso_11b.setColegio(colegio);
            cursoRepository.save(curso_11b);
            /*=======================[ASIGNATURAS]==================*/
            Asignatura matematica_11b = new Asignatura("Matemáticas");
            matematica_11b.setCurso(curso_11b);
            matematica_11b.setProfesor(nemesis);
            asignaturaRepository.save(matematica_11b);
            /*------------------------------------------------------*/
            Asignatura preicfes_11b = new Asignatura("Pre Icfes");
            preicfes_11b.setCurso(curso_11b);
            preicfes_11b.setProfesor(nemesis);
            asignaturaRepository.save(preicfes_11b);
            /*=======================[ESTUDIANTE]======================*/
            estudiantes.clear();
            Estudiante hermes = new Estudiante("Hermes");
            estudianteRepository.save(hermes);
            estudiantes.add(hermes);
            Estudiante hades = new Estudiante("Hades");
            estudianteRepository.save(hades);
            estudiantes.add(hades);
            Estudiante poseidon = new Estudiante("Poseidón");
            estudianteRepository.save(poseidon);
            estudiantes.add(poseidon);
            Estudiante zeus = new Estudiante("Zeus");
            estudianteRepository.save(zeus);
            estudiantes.add(zeus);
            
            /*=======================[Asignación]======================*/
            curso_11b = cursoRepository.findById(curso_11b.getId()).get();
            for (Asignatura asignatura : curso_11b.getAsignaturas()) {
                for (Estudiante estudiante : estudiantes) {
                    asignatura.getEstudiantes().add(estudiante);
                }
                asignaturaRepository.save(asignatura);
            }
            /*=========================================================*/
        }
    }
}
