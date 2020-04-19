import { Component, OnInit } from '@angular/core';

import { Events } from 'src/app/interfaces/events';

import { EventsService } from 'src/app/services/events/events.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  page: number = 0;
  eventsList: Events[];
  eventsListAux: Events[];
  lastPage: boolean = true;

  constructor(protected eventsService: EventsService) { }

  ngOnInit(): void {
    this.getEventsList();
  }

  private handleError(error: any) {
		console.error(error);
  }

  getEventsList(){
    this.eventsService.getEventsPage(this.page).subscribe(
      data => {
      this.eventsList = (data['content']);
      this.page = this.page + 1;
      console.log(data);
    },
    error => this.handleError(error)
    )
  }

  getNewEventsList(){
    this.eventsService.getEventsPage(this.page).subscribe(
      data => {
      if(data['empty'] == false){
      this.eventsListAux = (data['content']);
      this.eventsList = this.eventsList.concat(this.eventsListAux);
      this.page = this.page + 1;
      if(data['last']==true){
        this.lastPage = false
      }
    }
      console.log(data);
    },
    error => this.handleError(error)
    )
  }

}
