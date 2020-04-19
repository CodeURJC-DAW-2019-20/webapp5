import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MerchTypeService {
  baseURL: string = 'https://localhost:8443/api/merchandisings/';

  constructor(protected http: HttpClient) { }

  public getMerchType(id:number) {
    return this.http.get(this.baseURL + id + '/type');
  }
}
