import { Component, OnInit } from '@angular/core';
import { faDollarSign, faCalendar, faUsers } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  dashSection: string;

  public faIcons = {
    events: faCalendar,
    merch: faDollarSign,
    users: faUsers,
  }

  changeSection(newSection: string){
    this.dashSection = newSection;
  }

  constructor() { }

  ngOnInit(): void {
    this.dashSection = 'events';
  }

}
