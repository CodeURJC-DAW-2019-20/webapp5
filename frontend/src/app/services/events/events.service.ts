import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

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
}
