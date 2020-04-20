import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  baseURL: string = environment.apiEndPoint + '/users';

  constructor(protected http: HttpClient) { }

  public getEventsRegistered(id:number) {
    return this.http.get(this.baseURL + '/'+ id +'/eventsRegistered' );
  }



}
