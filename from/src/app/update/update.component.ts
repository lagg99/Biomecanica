import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from '../Service/service.service';
import { Maestras } from '../Modelo/Maestra';
import { UtilService } from '../Service/util/util.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  @Input() idMaestra: number;
  maestra: Maestras = { cdmaestro: null, 
    nmmaestro: null, 
    dsmaestro: null, 
    feregistro: null, 
    febaja: null };

  constructor(private router: Router,
    private service: ServiceService,
    private activateRouter: ActivatedRoute,
    private utilService:UtilService) { }

  ngOnInit(): void {
    this.editar();
  }
  editar() {
    let id = localStorage.getItem("id");
    this.service.getMaestraId(+id)
      .subscribe(data => {
        this.maestra = data;
      })
  }

  regresar() {
    this.router.navigate(['getAllMaestra']);
  }

  actualizar(maestra: Maestras) {
    this.utilService.confirmacion("Deseas Actualizar el registro?").then(respuesta =>{
      if (respuesta.isConfirmed) {
        Swal.fire('Registro Actualizado!', '', 'success')

        this.service.updateMaestra(maestra)
        .subscribe(data => {
          this.maestra = data;
          //alert("Maestra actualizada");
          this.router.navigate(['getAllMaestra']);
        })

      }else if (respuesta.isDenied) {
        Swal.fire('Cancelado', '', 'info')
      }
      })
  }
}

   