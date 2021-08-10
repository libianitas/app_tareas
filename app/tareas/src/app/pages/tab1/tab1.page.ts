import { HttpErrorResponse } from '@angular/common/http';
import { NodeWithI18n } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TareaService } from 'src/app/services/tarea.service';
import { ITarea } from 'src/app/type/ITarea';


@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit{
    descripTarea: '';
    tareas: ITarea[]=[];
    tarea: ITarea;
    constructor(
            public tareaService: TareaService)
      {
  }

  ngOnInit(): void {
   this.listarTareas();
  }
  listarTareas() {
  this.tareaService.listarTareas().subscribe(
      (res: ITarea[]) => {
        if (res) {
          this.tareas = res;
          document.getElementsByName('descripcion')[0]['value'] = '';
        } else {
          this.tareas = null;
        }
      },
      (error: HttpErrorResponse) => {
         console.log(error.message);
      }
    );
  }

  guardarTarea(descripcion){
    if(descripcion.length === 0){
      return;
    }
    console.log(descripcion);
    this.tarea = {
        id_tarea: 0,
        descripcion_tarea: descripcion,
        estado_tarea: false,
        fecha_crea_tarea: new Date()
    };

    this.tareaService.guardarTarea(this.tarea).subscribe(
      res => {
        // si es succes
        this.listarTareas();
       },
      error => {
       //error
     }
    );
  }

  cambioCheck(tarea)
  {
    console.log(tarea.estado_tarea);
    if(tarea.length === 0){
      return;
    }
    this.tareaService.guardarTarea(tarea).subscribe(
      res => {}
    );
  }

    eliminarTarea(tarea, i){
      this.tareaService.deleteTarea(tarea.id_tarea).subscribe(
        res => { this.listarTareas();}
    );
  }
}
