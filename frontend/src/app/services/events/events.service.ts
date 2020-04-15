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
    const url = environment.apiEndPoint + '/event/games/counts';

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
  saveEvent(event){
    
    const body = JSON.stringify(event);
    console.log(body);
    const headers = new HttpHeaders({
        'Content-Type': 'application/json',
    });

    const url = environment.apiEndPoint + '/events/'

    return this.http.post(url, event)
    .pipe(catchError((error) => this.handleError(error)));

/*
    if (!event.id) {
      return this.http
          .post<Events>(URL, body, { headers })
          .pipe(catchError((error) => this.handleError(error)));
  } else {
      return this.http
          .put<Book>(URL + book.id, body, { headers })
          .pipe(catchError((error) => this.handleError(error)));
  }*/
    //return true;
  }

  saveImage(id: number, image){
    const url = environment.apiEndPoint + '/events/' + id + '/image/'

    return this.http.post(url,image)
    .pipe(catchError((error) => this.handleError(error)));
    //return image;
  }
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
}
}