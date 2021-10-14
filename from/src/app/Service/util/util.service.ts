import { Injectable } from '@angular/core';
import { timer } from 'rxjs';
import { SweetAlert } from 'sweetalert/typings/core';
import swal, {SweetAlertIcon} from 'sweetalert2';
import Swal from 'sweetalert2';
@Injectable({
  providedIn: 'root'
})
export class UtilService {

  constructor() { }

  public success(message:string, title?: string):void{
    this.showAlert(title, message, 'success');
  }
  public info(message:string, title?: string):void{
    this.showAlert(title, message, 'info');
  }
  public error(message:string, title?: string):void{
    this.showAlert(title, message, 'error');
  }
  private showAlert(
    title:string, 
    message:string,
    icon:SweetAlertIcon
    ): void {
      swal.fire(title,message,icon);
  }

  confirmacion(mensaje : string){
    return Swal.fire({
      title: mensaje,
      showCancelButton: true,
      confirmButtonText: 'Aceptar',
      cancelButtonText : 'Cancelar',
    });
  }
  
}
