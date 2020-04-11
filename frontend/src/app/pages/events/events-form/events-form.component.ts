import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';

@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  event;
  gamesList: string[]=["1","2","3"];
  public flag: boolean;

  constructor() {
    this.event = new FormGroup({
      name: new FormControl(null,Validators.required),
      game: new FormControl(null,Validators.required),
      place: new FormControl(null,Validators.required),
      day: new FormControl(null,Validators.required),
      hour: new FormControl(null,Validators.required),
      description: new FormControl(null,Validators.required),
      isTournament: new FormControl(null,Validators.required),
      reward: new FormControl(null),
      groupSize: new FormControl(null,Validators.required),
      maxParticipants: new FormControl(null,Validators.required),
      inscriptionFee: new FormControl(null,Validators.required)
    }); 
  }

  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
    this.flag = false;
  }

  submit(){
    //this.name = name;
    //this.service.saveEvent(this.event);
    console.log(this.event.value);
  }
  showReward(){
    this.flag = true;
  }
  hideReward(){
    this.flag = false;
  }

}
