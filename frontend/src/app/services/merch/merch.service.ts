import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MerchService {

  constructor(protected http: HttpClient) { }

  getMerch() {
    return this.http.get('https://localhost:8443/api/merchandisings/38');
  }

  getMerchImage() {
    return this.http.get('https://localhost:8443/api/merchandisings/38/image');
  }
}
