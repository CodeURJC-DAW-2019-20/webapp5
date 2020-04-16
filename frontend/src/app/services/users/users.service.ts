import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { throwError, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Users } from 'src/app/interfaces/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {}
   
  register(userName: string,firstName: string,lastName: string,pass: string,mail: string){
    return ;
  }

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
  saveUser(user){
    const body = JSON.stringify(user);
    console.log(body);
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
    });

    const url = environment.apiEndPoint + '/users/'

    return this.http.post(url, user)
    .pipe(catchError((error) => this.handleError(error)));

  }
  private handleError
  
}
