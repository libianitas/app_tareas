package com.evaluacion.practica1.repository;
import com.evaluacion.practica1.model.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
        
}
