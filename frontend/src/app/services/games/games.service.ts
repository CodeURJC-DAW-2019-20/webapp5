import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  constructor(protected http: HttpClient) { }

  getGamesType() {

    const url = environment.apiEndPoint + '/events/games'

    return this.http.get(url);
  }


}
