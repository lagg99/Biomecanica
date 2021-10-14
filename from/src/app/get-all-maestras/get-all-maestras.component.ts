import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription, timer } from 'rxjs';
import { dataMaestra } from '../Modelo/dataMaestra';
import { Maestras } from '../Modelo/Maestra';
import { ServiceService } from '../Service/service.service';
import { UtilService } from '../Service/util/util.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-get-all-maestras',
  templateUrl: './get-all-maestras.component.html',
  styleUrls: ['./get-all-maestras.component.css']
})
export class GetAllMaestrasComponent implements OnInit {

  idMaestraSeleccionada:number;
  //maestras:Maestras[]=[];
  maestras: Maestras | any;
  subscripcion:Subscription
  dataMaestra:dataMaestra | any;



  constructor(private service:ServiceService, 
    private router:Router, private utilService : UtilService) { }

  ngOnInit(): void {
    this.getAllmaestras();
    //this.getmaestraByid();
    //this.getDataMaestra;
  }


  getAllmaestras(){
    this.service.getMaestra()
    .subscribe(data=>{
      this.maestras=data;
      console.log(this.maestras)
    });
  }
  
  updateMaestra(maestra:Maestras){
    localStorage.setItem("id",maestra.nmmaestro.toString());
    this.router.navigate(['update']);
  }

  cargardataMaestra(dataMaestra:dataMaestra){
    localStorage.setItem("id",dataMaestra.nmmaestro.toString());
    this.idMaestraSeleccionada=dataMaestra.nmmaestro;
    //this.router.navigate(['detailDataMaestra']);
  }


  deleteById(id: number){

    this.utilService.confirmacion("Deseas eliminar el registro?").then(respuesta =>{
      if (respuesta.isConfirmed) {
        Swal.fire('Registro eliminado!', '', 'success')
        
        this.service.deleteById(id).
        subscribe ();
          //alert("Maestra eliminada")
          
          location.reload();
          console.log("Que pasó?",respuesta)

      } else if (respuesta.isDenied) {
        Swal.fire('Cancelado', '', 'info')
      }
    })

    }
      
  

/*
  getmaestraByid(id:number){
    this.service.getMaestraId(id)
    .subscribe(data=>{
      this.maestras=data;
      console.log(this.maestras)
    });
  }*/

  //DATA MAESTRA

  formDataMaestra(maestra:Maestras){
    this.service.setMaestra(maestra)
    this.router.navigate(['dataMaestra']);
  }

  deleteDataMaestra(id:number){
    this.service.deleteDataMaestra(id).
    subscribe();
      alert("Dato eliminado")
      location.reload();
    
      
  }

  
  }
