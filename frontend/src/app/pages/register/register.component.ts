import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public userName: string;
  public pass: string;
  public firstName: string;
  public lastName: string;
  public mail: string;
  public loginService: LoginService;

  constructor(public userService: UsersService, public router: Router) {}

  ngOnInit(): void {
    if(this.loginService.isLogged){
      this.router.navigate(['/error']);
    }
  }

  register(){
    /*this.userService.register(this.userName,this.firstName,this.lastName,this.pass,this.mail).subscribe(
      (user) => {
        console.log(user);
        this.router.navigate(['/login']);
      },
      (error) => {
        console.log(error);
        alert('User already exist');
      }
    );
    */}
}
