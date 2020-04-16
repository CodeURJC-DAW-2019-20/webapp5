import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MerchTypeService {

  constructor(protected http: HttpClient) { }

  public getMerchType() {
    return this.http.get('https://localhost:8443/api/merchandisings/38/type');
  }
}
