import {
  Component,
  OnInit
} from "@angular/core";
import {
  SideNavService
} from "src/app/services/side-nav.service";
import {
  ApiService
} from "../../../../services/api.service";
import {
  DataService
} from "../../../../services/data.service";
import {
  MatSnackBar
} from '@angular/material/snack-bar';
import {
  NgxSpinnerService
} from "ngx-spinner";
@Component({
  selector: "app-side-nav",
  templateUrl: "./side-nav.component.html",
  styleUrls: ["./side-nav.component.css"]
})
export class SideNavComponent implements OnInit {

  constructor(public navService: SideNavService,
    public _api: ApiService,
    public _data: DataService,
    private snackBar: MatSnackBar,
    private spinner: NgxSpinnerService) {}
    public profesores: Array < any > ;
  ngOnInit() {
    this._api.getProfesores(this._api.getColegio).subscribe(data => {
      this.spinner.hide();
      this.profesores = data;
  },err=>{
    this.spinner.hide();
    console.warn(err);
    this.snackBar.open(err, '', {
    duration: 2000});
  });
  }


  cargar_asignaturas(id, profesor){
    this.spinner.show();
    this._api.getAsignaturas(id).subscribe(data => {
      this.spinner.hide();
      this._data.updateResultList(data);
      this.navService.closeNav();
      this.snackBar.open(profesor+" Tiene ("+data.length+") Asignaturas", '', {
        duration: 2000
      });

  },err=>{
    this.spinner.hide();
    console.warn(err);
    this.snackBar.open(err, '', {
    duration: 2000});
  });
      } 
}
