package com.evaluacion.practica1.rest;

import java.net.URI;
import java.util.List;

import com.evaluacion.practica1.model.Tarea;
import com.evaluacion.practica1.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/evaluacion")
public class TareaRest {
    @Autowired 
    private TareaService tareaService;
    
    @PostMapping("/tarea")
    private ResponseEntity<Tarea> createTarea (@Validated @RequestBody Tarea tarea){
        try{
            Tarea temporal = tareaService.createTarea(tarea);
            return ResponseEntity.created(new URI("/api/evaluacion/"+ temporal.getId_tarea())).body(temporal);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }
    @GetMapping("/tareas")
    private ResponseEntity<List<Tarea>> listarTodasTareas (){
       return ResponseEntity.ok(tareaService.getAllTareas());
    }

   @PutMapping("/tarea/{id}")
    private Tarea updateTarea (@PathVariable Integer id,@Validated @RequestBody Tarea tarea){
       return tareaService.createTarea(tarea);
    }


    @DeleteMapping(value = "/eliminar/{id}")
    private ResponseEntity<Boolean> deleteTarea(@PathVariable ("id") Integer id){
        tareaService.deleteById(id);
        return ResponseEntity.ok((tareaService.findById(id) != null));
    }
   
    @GetMapping("{estado}")
    private ResponseEntity<List<Tarea>> filtrarTarea (@PathVariable("estado") Boolean estado){
       return ResponseEntity.ok(tareaService.findAllByEstado(estado));
    }

}
