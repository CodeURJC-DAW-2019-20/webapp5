import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchService {
  imgUrl: string = 'https://localhost:8443/api/merchandisings/36/image';

  constructor(protected http: HttpClient) { }

  public getMerch() {
    return this.http.get('https://localhost:8443/api/merchandisings/38');
  }
  
  public getImage(): Observable<Blob> {
    return this.http.get(this.imgUrl, { responseType: 'blob' });
  }
}
