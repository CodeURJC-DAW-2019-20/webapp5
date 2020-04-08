import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from '../../../environments/environment'
import { Users } from 'src/app/interfaces/users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(
    private http: HttpClient,
  ) { }

  register(){

  }

  login(user: string, pass: string){
    let auth = window.btoa(user + ':' + pass);
    let url = environment.apiEndPoint + '/logIn'

    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });

    return this.http.get<Users>(url, { headers })
      .pipe(map(user => {

      /*if (user) {
        this.setCurrentUser(user);
        user.authdata = auth;
        localStorage.setItem('currentUser', JSON.stringify(user));
      }*/

      console.log(user);

      return user;
    }));
  }

  getUsers(){
    let url = environment.apiEndPoint + '/users'
  }
  
  getUser(id){
    let url = environment.apiEndPoint + '/users/' + id;
  }
}
