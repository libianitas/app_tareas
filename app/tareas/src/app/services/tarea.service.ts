import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment1 } from 'src/environments/environment';

import { ITarea } from '../type/ITarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  constructor(private http: HttpClient) { }
  public listarTareas(): Observable<ITarea[]> {
     return this.http.get<ITarea[]>(environment1.urlApi + 'tareas');
  }

  public guardarTarea(tarea: ITarea): Observable<ITarea> {
    return this.http.post<ITarea>(environment1.urlApi + 'tarea', tarea );
  }

  public modificarTarea(tarea: ITarea): Observable<ITarea> {
    return this.http.put<ITarea>(environment1.urlApi + 'tarea/', tarea);
  }

  public deleteTarea(id: number): Observable<any> {
    return this.http.delete(environment1.urlApi + 'eliminar/'+ id);
  }

}
