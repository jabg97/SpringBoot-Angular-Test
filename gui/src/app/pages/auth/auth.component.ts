import {
  Component,
  OnInit,
} from "@angular/core";
import {
  Router,
} from "@angular/router";
import {
  MatSnackBar
} from '@angular/material/snack-bar';
import {
  NgForm
} from '@angular/forms';
import {
  NgxSpinnerService
} from "ngx-spinner";
import {
  ApiService
} from "../../services/api.service";
@Component({
  selector: "app-auth",
  templateUrl: "./auth.component.html",
  styleUrls: ["./auth.component.css"]
})
export class AuthComponent implements OnInit {
  constructor(
    private router: Router,
    private _api: ApiService,
    private snackBar: MatSnackBar,
    private spinner: NgxSpinnerService
  ) {}

 form_data;any;

  LoginSubmit(fl: NgForm) {
    if (fl.valid) {
      this.spinner.show();
      this._api.login(fl.value.user).subscribe(data => {
        this.spinner.hide();
        localStorage.setItem('id_colegio', data.id);
        localStorage.setItem('nombre_colegio', data.nombre);
        this.router.navigateByUrl('');
        this.snackBar.open(data.nombre, '', {
          duration: 2000
        });

      },err=>{
        this.spinner.hide();
        console.warn(err);
          this.snackBar.open(err, '', {
          duration: 2000});
        });
    } else {
      this.snackBar.open('Formulario Incompleto.', '', {
        duration: 2000
      });
    }
  }
  RegisterSubmit(fr: NgForm) {
    if (fr.valid) {
      if (fr.value.password == fr.value.repassword) {
        this.spinner.show();
        this._api.register(fr.value.user).subscribe(data => {
        
          this.spinner.hide();
            localStorage.setItem('id_colegio', data.id);
            localStorage.setItem('nombre_colegio', data.nombre);
            this.router.navigateByUrl('');
            this.snackBar.open(data.nombre, '', {
              duration: 2000
            });

        },err=>{
          this.spinner.hide();
          console.warn(err);
          this.snackBar.open(err, '', {
          duration: 2000});
        });
      } else {
        this.snackBar.open("Las contraseñas no coinciden.", '', {
          duration: 2000
        });
      }
    } else {
      this.snackBar.open('Formulario Incompleto.', '', {
        duration: 2000
      });
    }
  }
  ngOnInit() {
    if (this._api.isLoggedIn) {
      this.router.navigateByUrl('')
    }

    this.form_data = {
      user:"1",
      email:"colegio@example.com",
      password:"password"
    };
  }
}
