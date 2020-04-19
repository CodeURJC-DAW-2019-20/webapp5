import { Component, OnInit } from '@angular/core';
import { LocalStorage } from 'ngx-webstorage';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @LocalStorage('currentUser')
  public currentUser;

  constructor() { }

  ngOnInit(): void {
  }

}
