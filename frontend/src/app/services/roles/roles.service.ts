import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(
    private http: HttpClient,
  ) { }



  getRoles(){
    const url = environment.apiEndPoint + '/role'

    return this.http.get(url)
      .pipe(
        map(purchase =>{
          return purchase;
        }),
        catchError(error => {
          return throwError(error);
        })
      );
  }
}
