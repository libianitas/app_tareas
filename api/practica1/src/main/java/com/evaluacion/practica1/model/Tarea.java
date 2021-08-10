package com.evaluacion.practica1.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tarea", schema = "evaluacion")
public class Tarea {

    public Tarea(int id_tarea, String descripcion_tarea, Boolean estado_tarea, Date fecha_crea_tarea,Date fecha_modifica_tarea) {
        this.id_tarea = id_tarea;
        this.descripcion_tarea = descripcion_tarea;
        this.estado_tarea = estado_tarea;
        this.fecha_crea_tarea = fecha_crea_tarea;
        this.fecha_modifica_tarea = fecha_modifica_tarea;
     }
        
     public Tarea () {
            
     }
    
    @Id
    @Column(length = 4)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tarea;

    @Column(nullable = false, length = 200, unique = true)   
    private String descripcion_tarea;

    @Column(nullable = false, columnDefinition = "boolean DEFAULT 'false'")
    private Boolean estado_tarea;

    @Column(nullable = false, columnDefinition = "Date DEFAULT 'now()'")
    private Date fecha_crea_tarea;
    
    private Date fecha_modifica_tarea;

     
    public int getId_tarea() {
        return this.id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getDescripcion_tarea() {
        return this.descripcion_tarea;
    }

    public void setDescripcion_tarea(String descripcion_tarea) {
        this.descripcion_tarea = descripcion_tarea;
    }

    public Boolean getEstado_tarea() {
        return this.estado_tarea;
    }

    public void setEstado_tarea(Boolean estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public Date getfecha_crea_tarea() {
        return this.fecha_crea_tarea;
    }

    public void setfecha_crea_tarea(Date fecha_crea_tarea) {
        this.fecha_crea_tarea = fecha_crea_tarea;
    }

    public Date getfecha_modifica_tarea() {
        return this.fecha_modifica_tarea;
    }

    public void setfecha_modifica_tarea(Date fecha_modifica_tarea) {
        this.fecha_modifica_tarea = fecha_modifica_tarea;
    }

}
