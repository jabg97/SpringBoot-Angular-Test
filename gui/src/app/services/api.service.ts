import {
  HttpClient,
  HttpErrorResponse
} from "@angular/common/http";
import {
  catchError
} from "rxjs/internal/operators";
import {
  Observable,
  throwError
} from "rxjs";
import {
  Injectable
} from "@angular/core";
import {
  Router
} from "@angular/router";


@Injectable({
  providedIn: "root"
})
export class ApiService {
  private url: string = "http://localhost:8080/api/v1/";

  constructor(private http: HttpClient, private router: Router) {}

  get getNombre(): string {
    return localStorage.getItem("nombre_colegio");
  }

  getAsignaturas(id): Observable < any > {
    return this.http
      .get < any > (this.url + "asignatura-profesor/" + id, {})
      .pipe(catchError(this.errorHandler));
  }

    login(id): Observable < any > {
      return this.http
        .get < any > (this.url + "colegio/" + id, {})
        .pipe(catchError(this.errorHandler));
  }

  register(id): Observable < any > {
    return this.http
      .get < any > (this.url + "colegio/" + id, {})
      .pipe(catchError(this.errorHandler));
}

getProfesores(id): Observable < any > {
  return this.http
    .get < any > (this.url + "profesor-colegio/" + id, {})
    .pipe(catchError(this.errorHandler));
}

  errorHandler(error: HttpErrorResponse) {
    return throwError(error.message || "Server error");
  }

  get isLoggedIn(): boolean {
    return !!localStorage.getItem("id_colegio");
  }

  get getColegio(): string {
    return localStorage.getItem("id_colegio");
  }

  get getUrl(): string {
    return this.url;
  }

  logout() {
    localStorage.removeItem("id_colegio");
    localStorage.removeItem("nombre_colegio");
    this.router.navigateByUrl("auth");
  }
}
