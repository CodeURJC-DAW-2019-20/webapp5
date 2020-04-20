import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LocalStorage } from 'ngx-webstorage';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public user;

  @LocalStorage('isUserLogged')
  public isUserLoggedIn;

  constructor(
    public userService: UsersService,
    public router: Router,
  ) {
    this.createUser();
  }

  ngOnInit(): void {
    if(this.isUserLoggedIn){
      this.router.navigate(['/error']);
    }
  }

  private createUser(){
    this.user = new FormGroup({
      name: new FormControl(null,Validators.required),
      email: new FormControl(null,Validators.required),
      firstName: new FormControl(null,Validators.required),
      lastName: new FormControl(null,Validators.required),
      roles: new FormControl(['ROLE_USER']),
      passwordHash: new FormControl(null,Validators.required),
      password: new FormControl(null,Validators.required),
    });
  }

  submit(){
    if(this.user.value.passwordHash == this.user.value.password){
      this.userService.saveUser(this.user.value).subscribe(
        (response) => {
          this.router.navigate(['/login'])
        },
        (error) => {
          if(error.status == 406 ){
            alert("Usuario ya existe con ese UserName");
          }
          console.error(error);
        }
      );
    }else{
      alert("Contraseñas no coinciden");
    }
  }
}
