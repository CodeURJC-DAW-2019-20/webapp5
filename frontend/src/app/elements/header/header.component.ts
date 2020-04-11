import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isMenuCollapsed = true;
  public isUserMenuCollapsed = true;
  public isUserLoggedIn = true;
  public isUserAdmin = true;
  public username = "byGranizo";

  constructor() { }

  ngOnInit(): void {
  }
  

}
