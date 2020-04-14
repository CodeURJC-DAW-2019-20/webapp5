import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: string;
  public pass: string;


  constructor(
    public userService: UsersService,
    public loginService: LoginService,
    public router: Router
    ) { }

  ngOnInit(): void {
  }

  login(){
    this.loginService.login(this.user, this.pass).subscribe(
      (user) => {
        console.log(user);
        this.router.navigate(['/']);
      },
      (error) => {
        console.log(error);
        alert('Invalid user or password');
      }
    );
  }
}
