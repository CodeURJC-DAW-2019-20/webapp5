import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchService {
  imgURL: string = 'https://localhost:8443/api/merchandisings/36/image';
  baseURL: string = 'https://localhost:8443/api/merchandisings';

  constructor(protected http: HttpClient) { }

  public getMerch(id:number) {
    return this.http.get(this.baseURL + '/' + id);
  }
  
  public getImage(): Observable<Blob> {
    return this.http.get(this.imgURL, { responseType: 'blob' });
  }

  public getMerchPage(page:number){
    return this.http.get(this.baseURL+'?page='+page);
  }
}
