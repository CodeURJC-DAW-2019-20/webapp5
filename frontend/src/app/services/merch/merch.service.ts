import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchService {

  constructor(protected http: HttpClient) { }

  getMerch() {
    return this.http.get('https://localhost:8443/api/merchandisings/38');
  }
  
  getMerchType() {
    return this.http.get('https://localhost:8443/api/merchandisings/38/type');
  }
  
  getImage(imageUrl: string): Observable<Blob> {
    return this.http.get(imageUrl, { responseType: 'blob' });
  }
}
