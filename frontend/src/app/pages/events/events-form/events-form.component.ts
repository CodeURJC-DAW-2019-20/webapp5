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

  constructor() {
    this.event = new FormGroup({
      name: new FormControl(null,Validators.required),
      game: new FormControl(null,Validators.required),
      place: new FormControl(null,Validators.required),
      day: new FormControl(null,Validators.required)
    }); 
  }

  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
  }

  submit(){
    //this.name = name;
    //this.service.saveEvent(this.event);
    console.log(this.event.value);
  }


}
