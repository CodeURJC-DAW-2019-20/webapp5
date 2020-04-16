import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-template',
  templateUrl: './event-template.component.html',
  styleUrls: ['./event-template.component.css']
})
export class EventTemplateComponent implements OnInit {

  event;
  name;

  constructor() {

    
   }

  ngOnInit(): void {
  }

}
