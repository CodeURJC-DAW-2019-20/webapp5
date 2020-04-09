import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';

@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  event;


  constructor(private service: EventsService, private formBuilder: FormBuilder,) {
    this.event = this.formBuilder.group({ name: '' });
  }

  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
  }

  submit(event){
    //this.name = name;
    this.service.saveEvent(this.event);
    console.log(this.event);
  }


}
