import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from '../../../environments/environment'
import { Users } from 'src/app/interfaces/users';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) {}
   
  register(){}

  getUsers(){
    let url = environment.apiEndPoint + '/users'
  }
  
  getUser(id){
    let url = environment.apiEndPoint + '/users/' + id;
  }
}
