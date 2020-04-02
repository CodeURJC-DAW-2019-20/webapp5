import { Component, OnInit } from '@angular/core';
import { Events } from '../../../interfaces/events';

@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  name: string;



 // event: Events


  constructor() { }

  ngOnInit(): void {
  }

  submit(name: string){
    this.name = name;
    console.log(this.name);
   }


}
