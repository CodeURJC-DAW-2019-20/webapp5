import { Component, OnInit } from '@angular/core';
import { EventRegisterService } from 'src/app/services/event-register/event-register.service';
import { EventsService } from 'src/app/services/events/events.service';

@Component({
  selector: 'app-events-dash',
  templateUrl: './events-dash.component.html',
  styleUrls: ['./events-dash.component.css']
})
export class EventsDashComponent implements OnInit {

  constructor(
    private eventRegisterService: EventRegisterService,
    private eventService: EventsService,
  ) { }

  ngOnInit(): void {
    this.getEventsByGameChartData();
    this.getInscriptionTableData();
  }

  getEventsByGameChartData(){
  }

  getInscriptionTableData(){
  }

}
