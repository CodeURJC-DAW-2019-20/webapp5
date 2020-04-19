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

  public getMerchType() {
    const url = environment.apiEndPoint + '/merchandisings/types'  
    console.log(url);
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
}
