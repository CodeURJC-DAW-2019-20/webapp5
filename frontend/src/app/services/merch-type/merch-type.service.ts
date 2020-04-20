import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { catchError, map } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchTypeService {

  constructor(protected http: HttpClient) { }

  public getMerchTypes() {
    const url = environment.apiEndPoint + '/merchandisings/types'  
    return this.http.get(url)
    .pipe(
      map(merchTypeList =>{
        return merchTypeList;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }
  public getMerchType(id:number) {
    const url = environment.apiEndPoint + '/merchandisings/' + id + '/type';
    return this.http.get(url);
  }
}
