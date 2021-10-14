import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { dataMaestra } from '../Modelo/dataMaestra';
import { Maestras } from '../Modelo/Maestra';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-maestras',
  templateUrl: './maestras.component.html',
  styleUrls: ['./maestras.component.css']
})
export class MaestrasComponent implements OnInit {


  idMaestraSeleccionada:number;
  //maestras:Maestras[]=[];
  maestras: Maestras | any;
  subscripcion:Subscription
  dataMaestra:dataMaestra | any;

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {

  }
  
}
