import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../Service/service.service';
import { Maestras } from '../Modelo/Maestra';
import { dataMaestra } from '../Modelo/dataMaestra';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private router: Router, private service:ServiceService) { }

  ngOnInit(): void {

  }

}
