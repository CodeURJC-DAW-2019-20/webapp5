import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Users } from 'src/app/interfaces/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {}
   
  register(){}

  getUsers(){
    const url = environment.apiEndPoint + '/users'

    return this.http.get(url)
      .pipe(
        map(user =>{
          return user;
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
