import { Component, OnInit } from '@angular/core';
import { dataMaestra } from '../Modelo/dataMaestra';
import { ServiceService } from '../Service/service.service';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  fecha='';
  dataMaestra:dataMaestra | any;
  dataMaestraII:dataMaestra | any;
  constructor(private service:ServiceService) { }

  ngOnInit(): void {
    this.getTipo();
    this.getGenero();
  }

  getTipo(){
    this.service.getTipo('02')
    .subscribe(data =>{
      this.dataMaestra=data;
      console.log(this.dataMaestra);
    });
  }
  getGenero(){
    this.service.getTipo('01')
    .subscribe(data =>{
      this.dataMaestraII=data;
      console.log(this.dataMaestraII);
    });
  }


}
