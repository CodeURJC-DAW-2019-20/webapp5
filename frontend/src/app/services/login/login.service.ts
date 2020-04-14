import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from '../../../environments/environment'
import { Users } from 'src/app/interfaces/users';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  isLogged = false;
  isAdmin = false;
  user : Users;
  auth : string;

  constructor(private http: HttpClient) {
    let user = JSON.parse(localStorage.getItem('currentUser'));
    if(user){
      console.log('Logged user');
  }
}
  login(user: string, pass: string){
    let auth = window.btoa(user + ':' + pass);
    let url = environment.apiEndPoint + '/logIn';

    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });

    return this.http.get<Users>(url, { headers })
      .pipe(map(user => {

      if (user) {
        this.setCurrentUser(user);
        user.authData = auth;
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
      console.log(user);
      return user;
    }));
  }
  logOut(){

    return this.http.get(URL + '/logOut').pipe(
      map(response => {
        this.removeCurrentUser();
        return response;
      }),
    );
  }

  private setCurrentUser(user: Users){
    this.isLogged = true;
    this.user = user;
    this.isAdmin = user.roles.indexOf('ROLE_ADMIN') !== -1;
  }
  removeCurrentUser(){
    localStorage.removeItem('currentUser');
    this.isLogged = false;
    this.isAdmin = false;
  }
}

