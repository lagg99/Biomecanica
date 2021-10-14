import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Maestras } from '../Modelo/Maestra';
import { ServiceService } from '../Service/service.service';
import { UtilService } from '../Service/util/util.service';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

     cdmaestro ='';
    dsmaestro='';

    maestra:Maestras;

  constructor(
    private router:Router, private service:ServiceService, private utilService:UtilService) { }

  ngOnInit(): void {
  }

      prepararParaGuardar(){
        
    this.utilService.confirmacion("Deseas agregar un nuevo registro?").then(respuesta =>{
      if (respuesta.isConfirmed) {
        Swal.fire('Se agregó un nuevo registro', '', 'success')
        

        const maestra = new Maestras(this.cdmaestro,this.dsmaestro);
        this.service.createMaestras(maestra).subscribe(
          data =>{
            //alert("Maestra creada");
            this.router.navigate(['/getAllMaestra'])
            location.reload();
          });

      } else if (respuesta.isDenied) {
        Swal.fire('Cancelado', '', 'info')
      }
    })

    } 

    guardar(maestra: Maestras){
      this.service.createMaestras(maestra)
      .subscribe(data=>{
        alert("Se agregó con exito")
        this.router.navigate(['getAllMaestra'])
      })
    }

}

