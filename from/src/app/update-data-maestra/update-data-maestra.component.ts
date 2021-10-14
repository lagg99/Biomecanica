import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { dataMaestra } from '../Modelo/dataMaestra';
import { UpdateDataMaestra } from '../Modelo/updateDataMaestra';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-update-data-maestra',
  templateUrl: './update-data-maestra.component.html',
  styleUrls: ['./update-data-maestra.component.css']
})
export class UpdateDataMaestraComponent implements OnInit {

  updateDateMaestro: UpdateDataMaestra | any;
  dataMaestra:dataMaestra | any;

  nmdato: number;
  nmmaestro:number;
    cddato='';
    dsdato='';
    cddato1='';
    cddato2='';
    cddato3='';
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.editar();
  }

  regresar(){
    this.router.navigate(['getAllMaestra'])
  }

editar(){
    let id=localStorage.getItem("id");
    this.service.getDataMaestra(+id)
    .subscribe(data=>{
      this.updateDateMaestro=data;
    })
      } 

}
