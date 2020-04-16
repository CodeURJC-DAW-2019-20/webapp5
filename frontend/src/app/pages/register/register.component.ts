import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public user;

  constructor(public userService: UsersService, public router: Router,public loginService: LoginService) {
    this.createUser();
  }

  ngOnInit(): void {
    if(this.loginService.isLogged){
      this.router.navigate(['/error']);
    }
    
  }

  private createUser(){
    this.user = new FormGroup({
      name: new FormControl(null,Validators.required),
      email: new FormControl(null,Validators.required),
      firstName: new FormControl(null,Validators.required),
      lastName: new FormControl(null,Validators.required),
      roles: new FormControl('ROLE_USER'),
      password: new FormControl(null,Validators.required),
    });
  }

  submit(){
    console.log(this.user.value);
    this.userService.saveUser(this.user.value).subscribe(
      (response) => {console.log("Ok")},
      (error) => {
        console.log("error");
      }
    );
    }
}
