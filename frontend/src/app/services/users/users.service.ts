import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

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
  }
  
  getUser(id){
    const url = environment.apiEndPoint + '/users/' + id;
  }
}
