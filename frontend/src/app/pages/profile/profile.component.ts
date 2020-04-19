import { Component, OnInit } from '@angular/core';
import { LocalStorage } from 'ngx-webstorage';
import { UsersService } from 'src/app/services/users/users.service'
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LocalStorageService } from 'ngx-webstorage';

import { ProfileService } from 'src/app/services/profile/profile.service';

import { Events } from 'src/app/interfaces/events';

import { EventsService } from 'src/app/services/events/events.service';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  @LocalStorage('currentUser')
  public currentUser;

  @LocalStorage('isUserLogged')
  public isUserLogged;

  eventList;
  gameId: number;
  gameName: string;
  aux: number;
  activeId;
  active;
  userForm: FormGroup;

  constructor(
    protected profileService: ProfileService, 
    protected eventsService: EventsService,
    public userService: UsersService,
    public router: Router,
    private localStorage: LocalStorageService) { }

  ngOnInit(): void {
    this.getUserEvents();
    if(!this.isUserLogged){
      this.router.navigate(['/error']);
    }
    this.createUserNewInfo();
  }

  getUserEvents() {
    this.profileService.getEventsRegistered(this.currentUser.id).subscribe(
      data => {
        this.eventList = data;
        this.getPopular();
      },
      error => this.handleError(error)
      )
    ;}

  getPopular(){
    console.log(this.eventList);
    this.eventList.forEach(element => {
      this.aux = element.event.game.id;
    })
    switch (this.aux) {
      case 1:
        this.gameId = 1;
        this.gameName = "League of Legends"
        break;
       
      case 2:
        this.gameId = 2;
        this.gameName = "Magic: The Gathering"
        break;

      case 3:
        this.gameId = 3;
        this.gameName = "Teamfight Tactics"
        break;      
        
      case 4:
        this.gameId = 4;
        this.gameName = "Legends of Runeterra"
        break;

      case 5:
        this.gameId = 5;
        this.gameName = "Hearthstone"
        break;

      default:
        break;
    }
    console.log(this.gameId);
    console.log(this.gameName);
  }

    
  private handleError(error: any) {
		console.error(error);
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

