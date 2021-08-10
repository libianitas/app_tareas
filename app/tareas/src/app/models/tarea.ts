export class Tarea {
    idTarea: number;
    descripcionTarea: string;
    estadoTarea: number;
    constructor(desc: string){
        //this.idTarea = id;
        this.descripcionTarea = desc;
        this.estadoTarea = 0;
    }
 }
