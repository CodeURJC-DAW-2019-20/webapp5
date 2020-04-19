import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MerchService {

  constructor(protected http: HttpClient) { }

  public getMerch(id:number) {
    const url = environment.apiEndPoint + '/merchandisings/' + id;
    return this.http.get(url);
  }
  
  public getImage(id:number): Observable<Blob> {
    const url = environment.apiEndPoint + '/merchandisings/' + id + '/image';
    return this.http.get(url, { responseType: 'blob' });
  }

  public getMerchPage(page:number){
    const url = environment.apiEndPoint + '/merchandisings?page=' + page;
    return this.http.get(url);
  }

  
}
