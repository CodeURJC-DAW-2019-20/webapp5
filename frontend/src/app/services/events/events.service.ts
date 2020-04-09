import { Injectable } from '@angular/core';
import { Events } from 'src/app/interfaces/events';

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  constructor() { }


  saveEvent(event: Events){
    return true;
  }


}
