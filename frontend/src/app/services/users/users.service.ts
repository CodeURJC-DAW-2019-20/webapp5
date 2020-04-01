import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../../environments/environment'

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
    let url = environment.apiEndPoint + '/users'
  }
  
  getUser(id){
    let url = environment.apiEndPoint + '/users/' + id;
  }
}
