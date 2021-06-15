
import {
  Injectable
} from "@angular/core";
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: "root"
})

export class DataService {
    private asignaturas: BehaviorSubject<any[]> = new BehaviorSubject<any[]>(null);
    public asignaturasObserver: Observable<any[]> = this.asignaturas.asObservable();
  
     public updateResultList(asignaturas) {
      this.asignaturas.next(asignaturas);
    }
  }