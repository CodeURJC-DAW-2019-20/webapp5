import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchService {
  baseURL: string = 'https://localhost:8443/api/merchandisings';

  constructor(protected http: HttpClient) { }

  public getMerch(id:number) {
    return this.http.get(this.baseURL + '/' + id);
  }
  
  public getImage(id:number): Observable<Blob> {
    return this.http.get(this.baseURL + '/' + id + '/image', { responseType: 'blob' });
  }

  public getMerchPage(page:number){
    return this.http.get(this.baseURL+'?page='+page);
  }
  
}
