import {
  Component,
  OnInit
} from "@angular/core";
import {
  Router
} from "@angular/router";
import {
  ApiService
} from "../../../services/api.service";

import {
  DataService
} from "../../../services/data.service";
import {
  EstudiantesDialogComponent
} from "./estudiantes-dialog/estudiantes-dialog.component";
import {
  NgxSpinnerService
} from "ngx-spinner";
import {MatDialog} from '@angular/material/dialog';
@Component({
  templateUrl: "./main.component.html",
  styleUrls: ["./main.component.css"],
  selector: "app-main"
})
export class MainComponent implements OnInit {
  asignaturas: any[];
  constructor(private router: Router,
    private _api: ApiService,
    private _data: DataService,
    private spinner: NgxSpinnerService,
    private dialog: MatDialog) {
    if (!this._api.isLoggedIn) {
      this.router.navigateByUrl('auth')
    }


    this._data.asignaturasObserver
    .subscribe(asignaturas => this.asignaturas = asignaturas)
  }

  ngOnInit() {

  }

  get_estudiantes(i) {
    this.dialog.open(EstudiantesDialogComponent, {
      data:{  
        curso: this.asignaturas[i].curso.grado+this.asignaturas[i].curso.salon,
        estudiantes: this.asignaturas[i].estudiantes
      },
    });
  }
}
