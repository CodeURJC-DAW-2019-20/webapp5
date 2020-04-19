import { Component, OnInit } from '@angular/core';
import { LocalStorage } from 'ngx-webstorage';

import { ProfileService } from 'src/app/services/profile/profile.service';

import { Events } from 'src/app/interfaces/events';

import { EventsService } from 'src/app/services/events/events.service';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @LocalStorage('currentUser')
  public currentUser;
  eventList;
  gameId: number;
  gameName: string;
  aux: number;
  activeId;
  active;

  constructor(protected profileService: ProfileService, protected eventsService: EventsService) { }

  ngOnInit(): void {
    this.getUserEvents();
  }

  getUserEvents() {
    this.profileService.getEventsRegistered(this.currentUser.id).subscribe(
      data => {
        this.eventList = data;
        console.log(data);
        this.getPopular();
      },
      error => this.handleError(error)
      )
    ;}

  getPopular(){
    console.log(this.eventList);
    this.eventList.forEach(element => {
      this.aux = element.event.game.id;
      console.log(element.event.game.id);
    })
    console.log(this.aux);
    switch (this.aux) {
      case 1:
        this.gameId = 1;
        this.gameName = "League of Legends"
        break;
       
      case 2:
        this.gameId = 2;
        this.gameName = "Magic: The Gathering"
        break;

      case 3:
        this.gameId = 3;
        this.gameName = "Teamfight Tactics"
        break;      
        
      case 4:
        this.gameId = 4;
        this.gameName = "Legends of Runeterra"
        break;

      case 5:
        this.gameId = 5;
        this.gameName = "Hearthstone"
        break;

      default:
        break;
    }
    console.log(this.gameId);
    console.log(this.gameName);
  }

    
  private handleError(error: any) {
		console.error(error);
  }

}
