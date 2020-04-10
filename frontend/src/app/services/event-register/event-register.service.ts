import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EventRegisterService {

  constructor(
    private http: HttpClient,
  ) { }

  getEventRegisterList(){
    const url = environment.apiEndPoint + '/event-register';

    return this.http.get(url)
      .pipe(
        map(eventRegister =>{
          return eventRegister;
        }),
        catchError(error => {
          return throwError(error);
        })
      );
  }
}
