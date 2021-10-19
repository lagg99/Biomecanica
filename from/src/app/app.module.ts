import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { MaestrasComponent } from './maestras/maestras.component';
import { DataMaestraComponent } from './data-maestra/data-maestra.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { InsertComponent } from './insertMaestra/insert.component';
import { GetAllMaestrasComponent } from './get-all-maestras/get-all-maestras.component'
import{FormsModule}from '@angular/forms';
import{ ServiceService } from './Service/service.service';
import {HttpClientModule} from '@angular/common/http';
import { UpdateComponent } from './update/update.component';
import { DetailDataMaestraComponent } from './detail-data-maestra/detail-data-maestra.component';
import { UpdateDataMaestraComponent } from './update-data-maestra/update-data-maestra.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { PersonaComponent } from './persona/persona.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MaestrasComponent,
    DataMaestraComponent,
    PageNotFoundComponent,
    InsertComponent,
    GetAllMaestrasComponent,
    UpdateComponent,
    DetailDataMaestraComponent,
    UpdateDataMaestraComponent,
    HomeComponent,
    PersonaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
