import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { catchError, map } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  constructor(protected http: HttpClient) { }

  getGamesType() {

    const url = environment.apiEndPoint + '/events/games'
    return this.http.get(url)
    .pipe(
      map(gameList =>{
        console.error(gameList);
        return gameList;
      }),
      catchError(error => {
        return throwError(error);
      })
    );
  }


}
