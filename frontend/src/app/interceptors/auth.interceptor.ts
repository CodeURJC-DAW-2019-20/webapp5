import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocalStorageService } from 'ngx-webstorage';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private localStorage: LocalStorageService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let localStore: LocalStorageService;

    let user = this.localStorage.retrieve('currentUser');

    if (user && user.authData){
      request = request.clone({
        setHeaders: {
          Authorization: "Basic " + user.authData,
        }
      });
    }
    return next.handle(request);
  }
}
