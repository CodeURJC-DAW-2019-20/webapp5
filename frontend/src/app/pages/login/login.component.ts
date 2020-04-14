import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: string;
  public pass: string;


  constructor(public userService: UsersService) { }

  ngOnInit(): void {
  }

  login(){
    this.userService.login(this.user, this.pass).subscribe(
      (user) => {
        console.log(user);
        this.dialogRef.close();
      },
      (error) => alert('Invalid user or password'),
    );
  }
  logOut() {
    this.userService.logOut().subscribe(
        (response) => {
            this.router.navigate(['/']);
        },
        (error) => console.log('Error when trying to log out: ' + error),
    );
}
}
