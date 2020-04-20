import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';
import { LocalStorage } from 'ngx-webstorage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: string;
  public pass: string;

  @LocalStorage('isUserLogged')
  public isUserLoggedIn;



  constructor(
    public loginService: LoginService,
    public router: Router
    ) { }

  ngOnInit(): void {
    if(this.isUserLoggedIn){
      this.router.navigate(['/error']);
    }
  }
  cancel(){
    this.router.navigate(['/']);
  }

  login(){
    this.loginService.login(this.user, this.pass).subscribe(
      (user) => {
        this.router.navigate(['/']);
      },
      (error) => {
        console.error(error);
        alert('Invalid user or password');
      }
    );
  }
}
