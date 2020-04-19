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

  setUserRole(userId: number, roleId: number){
    //Arreglar
    const url = environment.apiEndPoint + '/users/' + userId + "/role";

    const headers = new HttpHeaders({
      'Content-Type':  'application/json',
    });
    
    return this.http.put(url, JSON.stringify(roleId), {headers})
      .pipe(
        map(user =>{
          return user;
        }),
        catchError(error => {
          return throwError(error);
        })
      );
  }

  deleteUser(userId: number){
    const url = environment.apiEndPoint + '/users/' + userId;

    return this.http.delete(url)
      .pipe(
        map(user =>{
          return user;
        }),
        catchError(error => {
          return throwError(error);
        })
      );
  }


  saveUser(user){
    const body = JSON.stringify(user);
    console.log(body);
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
    });

    const url = environment.apiEndPoint + '/users/'

    return this.http.post(url, user,{headers})
    .pipe(
      map(user =>{
        return user;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }
}
