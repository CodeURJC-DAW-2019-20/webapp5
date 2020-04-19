import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { catchError, map } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MerchService {
  baseURL: string = environment.apiEndPoint + '/merchandisings';

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

  saveMerch(merch){
    const body = JSON.stringify(merch);
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
    });
    return this.http.post(this.baseURL+'/', merch, {headers})
    .pipe(
      map(merchSend =>{
        return merchSend;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }

  saveImage(id: number, image){
    return this.http.post(this.baseURL+'/'+ id + '/image/',image)
    .pipe(
      map(eventRegister =>{
        return eventRegister;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
    //return image;
  }
}
