import { Component, OnInit } from '@angular/core';
import { EventRegisterService } from 'src/app/services/event-register/event-register.service';
import { EventsService } from 'src/app/services/events/events.service';


@Component({
  selector: 'app-events-dash',
  templateUrl: './events-dash.component.html',
  styleUrls: ['./events-dash.component.css']
})
export class EventsDashComponent implements OnInit {

  public eventsByGame: any = [];
  public inscriptions: any;

  constructor(
    private eventRegisterService: EventRegisterService,
    private eventService: EventsService,
  ) { }

  ngOnInit(): void {
    this.getEventsByGameChartData();
    this.getInscriptionTableData();

    setTimeout(() => {
    }, 1000);
  }

  getEventsByGameChartData(){
    this.eventService.getEventGamesCount().subscribe(
      eventsByGame => {

        let gamesArray: string[];
        let eventsArray: number[];

        if (eventsByGame instanceof Array) {
          gamesArray = eventsByGame.map(game =>{
            return game[0];
          });

          eventsArray = eventsByGame.map(game =>{
            return game[1];
          });

          this.eventsByGame[0] = gamesArray;
          this.eventsByGame[1] = eventsArray;
        }
      },
      error => {
        console.error(error);
      }
    );
  }

  getInscriptionTableData(){
    this.eventRegisterService.getEventRegisterList().subscribe(
      inscriptions => {
        this.inscriptions = inscriptions;
      },
      error => {
        console.error(error);
      }
    );
  }
}
