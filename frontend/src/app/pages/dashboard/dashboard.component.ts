import { Component, OnInit } from '@angular/core';
import { faDollarSign, faCalendar, faUsers } from '@fortawesome/free-solid-svg-icons';
import { LoginService } from 'src/app/services/login/login.service';
import { LoginComponent } from '../login/login.component';
import { Router } from '@angular/router';
import { LocalStorage } from 'ngx-webstorage';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  dashSection: string;
  @LocalStorage('isUserAdmin')
  public isUserAdmin;


  public faIcons = {
    events: faCalendar,
    merch: faDollarSign,
    users: faUsers,
  }

  changeSection(newSection: string){
    this.dashSection = newSection;
  }

  constructor(public router: Router) { }

  ngOnInit(): void {
    if(!this.isUserAdmin){
      this.router.navigate(['/error']);
    }
    this.dashSection = 'events';
  }

}
