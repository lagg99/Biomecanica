import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Maestras } from '../Modelo/Maestra';
import {tap} from 'rxjs/operators'
import { dataMaestra } from '../Modelo/dataMaestra';
import { UpdateDataMaestra } from '../Modelo/updateDataMaestra';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {


  maestra:Maestras;

  constructor(private http:HttpClient) { }


  url='http://localhost:1020/bmc/maestras/getAll';
  url2='http://localhost:1020/bmc/maestras/saveOrUpdateMaestra';
  url4='http://localhost:1020/bmc/maestras/getMaestraById';

  urlprueba='http://localhost:1020/bmc/maestras/getMaestraById/1';

  
  getMaestra(){
    return this.http.get<Maestras[]>(this.url);
  }
  createMaestras(maestra:Maestras): Observable<Maestras>{
    return this.http.post<Maestras>(this.url2,maestra)
  }
  getMaestraId(id:number){
    return this.http.get<Maestras>(this.url4+"/"+id);
  }
  updateMaestra(maestra:Maestras){
    return this.http.post<Maestras>(this.url2,maestra);
  }
  deleteById(id:number){
    return this.http.delete<Maestras>(`http://localhost:1020/bmc/maestras/deleteMaestrasById/${id}`).
    pipe(
      tap(()=>{
      })
    )
  }

  getMaestraprueba(){
    return this.http.get<dataMaestra[]>(this.urlprueba)
  }
  
  /* DATA MAESTRA */
/* DATA MAESTRA */

urlDataMaestraBase='http://localhost:1020/bmc/datamaestra';



createDataMaestras(dataMaestra:dataMaestra): Observable<dataMaestra>{
  return this.http.post<dataMaestra>(this.urlDataMaestraBase+'/savedDataMaestra',dataMaestra);
}

deleteDataMaestra(id: number){
  return this.http.delete<dataMaestra>(this.urlDataMaestraBase+'/deleteDataMaestra/'+`${id}`).
  pipe(
    tap(()=>{

    })
  )
}
getDataMaestra(id: number){
  return this.http.get<dataMaestra>(this.urlDataMaestraBase+'/getDataMaestra/'+`${id}`);
}

UpdateDataMaestras(dataMaestra:UpdateDataMaestra): Observable<UpdateDataMaestra>{
  return this.http.put<UpdateDataMaestra>(this.urlDataMaestraBase+'/update'+dataMaestra.nmdato,dataMaestra);
}

setMaestra(maestra: Maestras){
  this.maestra=maestra;
  console.log(this.maestra)
}

getMaestraSeleccionada(){
  return this.maestra;
}

}