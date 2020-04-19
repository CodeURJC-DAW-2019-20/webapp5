import { Component, OnInit } from '@angular/core';

import { Events } from 'src/app/interfaces/events';

import { EventsService } from 'src/app/services/events/events.service';

import { ActivatedRoute } from "@angular/router";

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
  activatedRoute: ActivatedRoute;
  gameId: number = 0;

  constructor(protected eventsService: EventsService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.gameId = this.route.snapshot.queryParams['id'];
    if(this.gameId == null)
      this.getEventsList();
    else{
      this.getEventsListByGame();
  }
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

  showMore(){
    if(this.gameId == null){
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
  }else{
    this.eventsService.getEventsPageByGame(this.page, this.gameId).subscribe(
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

  getEventsListByGame(){
    this.eventsService.getEventsPageByGame(this.page, this.gameId).subscribe(
      data => {
      this.eventsList = (data['content']);
      this.page = this.page + 1;
      console.log(data);
      if(data['last']==true){
        this.lastPage = false
      }
    },
    error => this.handleError(error)
    )
  }


}
