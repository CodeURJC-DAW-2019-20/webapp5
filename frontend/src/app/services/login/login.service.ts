import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { LocalStorageService } from 'ngx-webstorage';

import { environment } from '../../../environments/environment'
import { Users } from 'src/app/interfaces/users';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  user : Users;
  auth : string;

  constructor(
    private http: HttpClient,
    private localStorage: LocalStorageService
    ) {

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
        user.authData = auth;
        this.setCurrentUser(user);
      }
      return user;
    }));
  }

  logOut(){
    let url = environment.apiEndPoint + '/logOut';
    
    return this.http.get(url).pipe(
      map(response => {
        this.removeCurrentUser();
        return response;
      }),
    );
  }

  private setCurrentUser(user: Users){
    this.localStorage.store('currentUser', user);
    this.localStorage.store('isUserLogged', true);
    this.localStorage.store('isUserAdmin', user.roles.indexOf('ROLE_ADMIN') !== -1);
  }
  removeCurrentUser(){
    this.localStorage.clear();
  }
}

