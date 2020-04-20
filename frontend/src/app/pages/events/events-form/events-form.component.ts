import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';
import { HttpClient } from '@angular/common/http';
import { GamesService } from 'src/app/services/games/games.service';
import { throwError, Observable } from 'rxjs';
import { Games } from 'src/app/interfaces/games';
import { Router } from '@angular/router';
import { LocalStorage } from 'ngx-webstorage';


@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  @LocalStorage('isUserAdmin')
  public isUserAdmin;

  public event;
  gamesList: Games[];
  public reward: boolean;
  selectedFile: File;
  receivedImageData: any;
  eventNumber: number;
  eventCreated;
  eventId;

  constructor(private httpClient: HttpClient, public eventService: EventsService, public gamesService: GamesService,public router: Router) {
    this.createEvent();
  }

  // on init, get the events list
  ngOnInit(): void{
    if(!this.isUserAdmin){
      this.router.navigate(['/error']);
    }
    this.createGamesList();
    this.reward = false;
  }

  public onFileChanged(event) {
    this.selectedFile = event.target.files[0];
    this.event.controls['haveImage'].setValue(true);
  }

  private createEvent(){
    
    this.event = new FormGroup({
      name: new FormControl(null,Validators.required),
      game: new FormControl(null,Validators.required),
      haveImage: new FormControl(false),
      place: new FormControl(null,Validators.required),
      date: new FormControl(null,Validators.required),
      time: new FormControl(null,Validators.required),
      description: new FormControl(null,Validators.required),
      isTournament: new FormControl(null,Validators.required),
      reward: new FormControl(null),
      groupSize: new FormControl(null,Validators.required),
      maxParticipants: new FormControl(null,Validators.required),
      inscriptionFee: new FormControl(null,Validators.required)
    });
  }

 // upload image of the new event
  uploadImage() {
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile);
    this.eventService.saveImage(this.eventNumber,uploadImageData).subscribe(
      (response) => {
      },
      (error) => {
        console.error(error);
      },
    );
  }

  private createGamesList() {
    this.gamesService.getGamesType().subscribe(
      response => {
        this.gamesList = response as Games[];
      },
      error => this.handleError(error)
    );
  }

  //upload a new event
  submit(){
    this.eventService.saveEvent(this.event.value).subscribe(
      (response) => {
        this.eventCreated = response;
        this.eventNumber = this.eventCreated.id;
        this.router.navigate(['/event-template'],{ queryParams: { id: this.eventNumber}});
        if(this.event.value.haveImage){
          this.uploadImage();
        } 
      },
      (error) => {
        console.error(error);
      },
    );
     
  }
  //show div of reward
  showReward(){
    this.reward = true;
  }
  //hide div of reward
  hideReward(){
    this.reward = false;
  }
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }
}
