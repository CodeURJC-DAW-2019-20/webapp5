import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public user: string;
  public pass: string;
  public name: string;
  public lastname: string;
  public mail: string;

  constructor(public userService: UsersService, public router: Router,) {}

  ngOnInit(): void {
  }

  register(){
    this.userService.register().subscribe(
      (user) => {
        console.log(user);
        this.router.navigate(['/']);
      },
      (error) => {
        console.log(error);
        alert('User already exist');
      }
    );
  }
}
