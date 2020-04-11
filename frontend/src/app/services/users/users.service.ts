import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(
    private http: HttpClient,
  ) { }

  register(){

  }

  login(){

  }

  getUsers(){
    const url = environment.apiEndPoint + '/users'

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
  
  getUser(id){
    const url = environment.apiEndPoint + '/users/' + id;
  }
}
