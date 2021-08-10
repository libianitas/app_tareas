package com.evaluacion.practica1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.evaluacion.practica1.model.Tarea;
import com.evaluacion.practica1.repository.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    
    public Tarea createTarea (Tarea tarea)
    {
       return tareaRepository.save(tarea);
    }

    public List<Tarea> getAllTareas (){
        return tareaRepository.findAll();
    }

    public void deleteById (int id)
    {
        tareaRepository.deleteById(id);
    }

    public Optional<Tarea> findById(Integer id)
    {
        return tareaRepository.findById(id);    
    }
    
    public List<Tarea> findAllByEstado(Boolean estadoIn){
        List<Tarea> tareaRespuesta =  new ArrayList<>();
        List<Tarea> tarea = tareaRepository.findAll();
        for (int i=0; i<tarea.size(); i++)
        {
          if(tarea.get(i).getEstado_tarea() == estadoIn)
          {
             tareaRespuesta.add(tarea.get(i));
          }
        }
        return tareaRespuesta;
    }
}
