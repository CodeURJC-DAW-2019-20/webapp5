import { Injectable } from '@angular/core';
import { Events } from 'src/app/interfaces/events';
import { environment } from 'src/environments/environment';
import { throwError, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  constructor(
    private http: HttpClient,
  ) { }

  getEventGamesCount(){
    const url = environment.apiEndPoint + '/events/games/counts';

    return this.http.get(url)
      .pipe(
        map(eventGame =>{
          return eventGame;
        }),
        catchError(error => {
          return throwError(error);
        })
      );
  }

  public getEvent(id: number) {
    const url = environment.apiEndPoint + '/events/'+ id;
    return this.http.get(url)
    .pipe(
      map(eventSend =>{
        return eventSend;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }

  public getEventsPage(page: number) {
    const url = environment.apiEndPoint + '/events?page='+ page;
    return this.http.get(url)
    .pipe(
      map(eventPageSend =>{
        return eventPageSend;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }
  public getEventsPageByGame(page: number, id:number) {
    const url = environment.apiEndPoint + '/events?page='+ page + '&gameId=' + id;
    return this.http.get(url)
    .pipe(
      map(eventPageSend =>{
        return eventPageSend;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }

  saveEvent(event){
    const body = JSON.stringify(event);
    console.log(body);
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
    });

    const url = environment.apiEndPoint + '/events/'

    return this.http.post(url, event, {headers})
    .pipe(
      map(eventSend =>{
        return eventSend;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }

  saveImage(id: number, image){
    const url = environment.apiEndPoint + '/events/' + id + '/image/'

    return this.http.post(url,image)
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
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }

  public getImage(id: number): Observable<Blob> {
    const url = environment.apiEndPoint + '/events/'+ id +'/image';
    return this.http.get(url, { responseType: 'blob' });
  }

  saveInscription(id: number, inscription){
    const url = environment.apiEndPoint + '/userRegisterEvent/'+ id ;//id of event
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    return this.http.post(url,inscription,{headers})
    .pipe(
      map(eventRegister =>{
        return eventRegister;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }
}