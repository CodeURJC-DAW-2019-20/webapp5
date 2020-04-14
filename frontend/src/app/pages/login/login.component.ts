import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: string;
  public pass: string;


  constructor(public userService: UsersService,public loginService: LoginService) { }

  ngOnInit(): void {
  }

  login(){
    this.loginService.login(this.user, this.pass).subscribe(
      (user) => {
        console.log(user);
      },
      (error) => {
        console.log(error);
        alert('Invalid user or password');
      }
    );
  }
  logOut() {
    this.loginService.logOut().subscribe(
        (response) => {
            //this.router.navigate(['/']);
        },
        (error) => console.log('Error when trying to log out: ' + error),
    );
}
}
