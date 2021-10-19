import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HeaderComponent} from './header/header.component';
import { InsertComponent } from './insertMaestra/insert.component';
import { GetAllMaestrasComponent } from './get-all-maestras/get-all-maestras.component';
import{UpdateComponent}from './update/update.component'
import { DataMaestraComponent } from './data-maestra/data-maestra.component';
import { DetailDataMaestraComponent } from './detail-data-maestra/detail-data-maestra.component';
import {UpdateDataMaestraComponent} from './update-data-maestra/update-data-maestra.component'
import{HomeComponent} from './home/home.component'
import { PersonaComponent } from './persona/persona.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:'/home',
    pathMatch:'full'
  },
  {
    path : 'header',
    component: HeaderComponent
  },
  {
    path:'getAllMaestra',
    component:GetAllMaestrasComponent
  },
  {
    path:'update',
    component:UpdateComponent
  },
  {
    path:'dataMaestra',
    component:DataMaestraComponent
  },
  {
  path:'detailDataMaestra',
  component:DetailDataMaestraComponent
  },
  {
    path:'updateDataMaestra',
    component:UpdateDataMaestraComponent
    },
  {
    path: 'home',
    component:HomeComponent
  },
  {
  path:'addMaestra',
  component:InsertComponent
  },
  {
    path:'person',
    component:PersonaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }