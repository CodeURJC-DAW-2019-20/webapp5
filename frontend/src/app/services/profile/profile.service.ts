import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  baseURL: string = 'https://localhost:8443/api/users';

  constructor(protected http: HttpClient) { }

  public getEventsRegistered(id:number) {
    return this.http.get(this.baseURL + '/'+ id +'/eventsRegistered' );
  }



}
