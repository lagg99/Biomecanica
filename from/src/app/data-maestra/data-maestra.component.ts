import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { dataMaestra } from '../Modelo/dataMaestra';
import { ServiceService } from '../Service/service.service';
import{Maestras} from '../Modelo/Maestra'
import { UtilService } from '../Service/util/util.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-data-maestra',
  templateUrl: './data-maestra.component.html',
  styleUrls: ['./data-maestra.component.css']
})
export class DataMaestraComponent implements OnInit {

  dataMaestra:dataMaestra | any;
  //dataMaestra:dataMaestra[]=[];
  maestra:Maestras;

  nmdato:number;
  nmmaestro: number;
    cddato='';
    dsdato='';
    cddato1='';
    cddato2='';
    cddato3='';

    maestraSeleccionada:Maestras;

  constructor(private router:Router, private service:ServiceService, private utilService: UtilService) { }

  ngOnInit(): void {
   this.maestraSeleccionada = this.service.getMaestraSeleccionada();
   this.nmmaestro=this.maestraSeleccionada?.nmmaestro;
  }

  regresar(){
    this.router.navigate(['getAllMaestra'])
  }

  getDataMaestra(id: number){
    return this.service.getDataMaestra(id).
    subscribe(data=>{
      this.dataMaestra=data;
   //   this.router.navigate(['dataMaestra']);
      console.log(this.dataMaestra);
    })
  }

  prepararParaGuardar(){
    this.utilService.confirmacion("Deseas agregar datos al maestro").then(respuesta =>{
      if (respuesta.isConfirmed) {
        Swal.fire('Datos agregados!', '', 'success')


        const DataMaestra = new dataMaestra(this.nmdato,this.nmmaestro,this.cddato,this.dsdato,
          this.cddato1,this.cddato2,this.cddato3);
        
        this.service.createDataMaestras(DataMaestra).subscribe(
        data =>{

        this.router.navigate(['/getAllMaestra'])
        });

      }else if (respuesta.isDenied) {
        Swal.fire('Cancelado', '', 'info')
      }
      })
      } 
  
    guardar(dataMaestra: dataMaestra){
      this.service.createDataMaestras(dataMaestra)
      .subscribe(data=>{
        alert("Se agregó con exito")
        this.router.navigate(['dataMaestra'])
      })
    }

}


