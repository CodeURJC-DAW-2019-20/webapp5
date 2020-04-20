import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterComponent } from 'src/app/pages/register/register.component';
import { registerLocaleData } from '@angular/common';

@Injectable()
export class ValidatorInterceptor implements HttpInterceptor {
  constructor(public register: RegisterComponent){}


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let pass = JSON.parse(this.register.getItem());
    let confirmPass = JSON.parse(this.register.getItem());
    if(pass == confirmPass){
      this.register.activate();
    }
    return next.handle(request);
  }
}
