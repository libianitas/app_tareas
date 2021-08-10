import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit  } from '@angular/core';
import { TareaService } from 'src/app/services/tarea.service';
import { ITarea } from 'src/app/type/ITarea';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit{
  tareasCompletas: ITarea[]=[];

constructor(private tareaService: TareaService) {
}
ngOnInit(): void {
  this.listarTareasCompletas();
 }
 ngAfterViewInit() {
  this.listarTareasCompletas();
}
listarTareasCompletas() {
  this.tareaService.filtrarTareasEstado(true).subscribe(
      (res: ITarea[]) => {
        if (res) {
          this.tareasCompletas = res;
        }
          else {
          this.tareasCompletas = null;
        }
      },
      (error: HttpErrorResponse) => {
         console.log(error.message);
      }
    );
  }
}
