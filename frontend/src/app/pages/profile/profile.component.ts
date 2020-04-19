import { Component, OnInit } from '@angular/core';
import { LocalStorage } from 'ngx-webstorage';
import { UsersService } from 'src/app/services/users/users.service'
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @LocalStorage('currentUser')
  public currentUser;
  userForm: FormGroup;
  
  active;

  constructor(
    public userService: UsersService,
    public router: Router,
    private localStorage: LocalStorageService
  ) { }

  ngOnInit(): void {
    this.createUserNewInfo();
  }

  createUserNewInfo(){
    this.userForm = new FormGroup ({
      email: new FormControl(this.currentUser.email, Validators.required),
      firstName: new FormControl(this.currentUser.firstName, Validators.required),
      lastName: new FormControl(this.currentUser.lastName, Validators.required)
    });
  }

  editProfile() {  
    this.userService.editUser(this.currentUser.id, this.userForm.value).subscribe(
      (response) => {
        console.log("Ok");
        console.log(this.userForm.value);

        this.currentUser.email = this.userForm.value.email;
        this.currentUser.firstName = this.userForm.value.firstName;
        this.currentUser.lastName = this.userForm.value.lastName;

        this.localStorage.store('currentUser', this.currentUser);
        
        this.active = 1;
      },
      (error) => {
        if(error.status == 406){
          alert("error");
        }
        console.log(error);
      }
    );
  }

}
