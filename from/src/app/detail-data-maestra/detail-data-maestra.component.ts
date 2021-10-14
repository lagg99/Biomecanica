import { Component, OnInit, Input, SimpleChange} from '@angular/core';
import { Router } from '@angular/router';
import { MaestrasComponent } from '../maestras/maestras.component';
import { dataMaestra } from '../Modelo/dataMaestra';
import { Maestras } from '../Modelo/Maestra';
import { ServiceService } from '../Service/service.service';
import Swal from 'sweetalert2'
import { UtilService } from '../Service/util/util.service';
import { UpdateDataMaestra } from '../Modelo/updateDataMaestra';

@Component({
  selector: 'app-detail-data-maestra',
  templateUrl: './detail-data-maestra.component.html',
  styleUrls: ['./detail-data-maestra.component.css']
})
export class DetailDataMaestraComponent implements OnInit {

  @Input() idMaestra:number;
  dataMaestra:dataMaestra | any;
  maestra:Maestras | any;
  updateDataMaestra:UpdateDataMaestra| any;

  constructor(private router:Router, private service:ServiceService, private utilService:UtilService) { }

  ngOnInit(): void {
   
  }

  getDataMaestra(id: number){
    return this.service.getDataMaestra(id).
    subscribe(data=>{
      this.dataMaestra=data;
    // this.router.navigate(['dataMaestra']);
      console.log(this.dataMaestra);
    })
  }

  regresar(){
    this.router.navigate(['getAllMaestra'])
  }

  ngOnChanges(changes: { [property: string]: SimpleChange }){
    // Extract changes to the input property by its name
    if(this.idMaestra)
    this.getDataMaestra(this.idMaestra);
 // Whenever the data in the parent changes, this method gets triggered. You 
 // can act on the changes here. You will have both the previous value and the 
 // current value here.
 }

 deleteDataMaestra(id: number){

  this.utilService.confirmacion("Deseas eliminar el registro?").then(respuesta =>{
    if (respuesta.isConfirmed) {
      Swal.fire('Registro eliminado!', '', 'success')
   this.service.deleteDataMaestra(id)
   .subscribe();
   //alert("Dato eliminado")
   location.reload();

    }else if (respuesta.isDenied) {
    Swal.fire('Cancelado', '', 'info')
  }
 })
}

 EditarDataMaestra(updateDataMaestra:UpdateDataMaestra): void{
   localStorage.setItem("id", updateDataMaestra.nmdato.toString());
  this.router.navigateByUrl('/updateDataMaestra');
}
}
