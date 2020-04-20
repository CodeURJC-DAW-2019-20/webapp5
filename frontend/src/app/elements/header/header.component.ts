import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';
import { LocalStorage } from 'ngx-webstorage';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isMenuCollapsed = true;
  public isUserMenuCollapsed = true;

  @LocalStorage('currentUser')
  public currentUser;

  @LocalStorage('isUserLogged')
  public isUserLoggedIn;

  @LocalStorage('isUserAdmin')
  public isUserAdmin;

  constructor(
    public loginService: LoginService,
    public router: Router,
  ) { }

  ngOnInit(): void { 
  }

  logOut() {
    this.isUserMenuCollapsed = true
    this.loginService.logOut().subscribe(
      (response) => {
        this.router.navigate(['/']);
      },
      (error) => console.error('Error when trying to log out: ' + error),
    );
  }
  

}
