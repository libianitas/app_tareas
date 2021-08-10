import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit  } from '@angular/core';
import { TareaService } from 'src/app/services/tarea.service';
import { ITarea } from 'src/app/type/ITarea';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})


export class Tab2Page implements OnInit{
    tareasActivas: ITarea[]=[];
    tareasCompletas: ITarea;

  constructor(private tareaService: TareaService) {}
  ngOnInit(): void {
      this.listarTareasActivas();
      console.log('entro');
   }
   ngAfterViewInit() {
    this.listarTareasActivas();
  }

  listarTareasActivas() {
    this.tareaService.filtrarTareasEstado(false).subscribe(
        (res: ITarea[]) => {
          if (res) {
            this.tareasActivas = res;
          }
            else {
            this.tareasActivas = null;
          }
        },
        (error: HttpErrorResponse) => {
           console.log(error.message);
        }
      );
    }
}
