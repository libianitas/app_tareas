import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TareaService } from 'src/app/services/tarea.service';
import { ITarea } from 'src/app/type/ITarea';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage {
  tareasFiltradas: ITarea[]=[];
  constructor(private tareaService: TareaService,
              private router: Router) {}
    listarTareasFiltradas(condicion) {
    this.tareaService.filtrarTareasEstado(condicion).subscribe(
        (res: ITarea[]) => {
          if (res) {
            this.tareasFiltradas = res;
          }
            else {
            this.tareasFiltradas = null;
          }
        },
        (error: HttpErrorResponse) => {
           console.log(error.message);
        }
      );
    }

}
