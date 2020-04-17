import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';
import { HttpClient } from '@angular/common/http';
import { GamesService } from 'src/app/services/games/games.service';
import { throwError, Observable } from 'rxjs';


@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  public event;
  gamesList: string[]=["1","2","3"];
  games;
  public reward: boolean;
  selectedFile: File;
  receivedImageData: any;
  eventNumber: number;

  constructor(private httpClient: HttpClient, public eventService: EventsService, public gamesService: GamesService) {
    this.createEvent();
  }

  public onFileChanged(event) {
    console.log(event);
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

 // This part is for uploading
  onUpload() {
    console.log(this.selectedFile);
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile);
    this.eventService.saveImage(this.eventNumber,uploadImageData).subscribe(
      (response) => {
        console.log("nice image");
      },
      (error) => {
        console.log("error image");
      },
    );
  }

  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
    //this.createGamesList();
    this.reward = false;
  }

  private createGamesList() {
    this.games = this.gamesService.getGamesType();
    
    console.log(this.games);
  }

  submit(){
    
    console.log(this.event.value);
    this.eventService.saveEvent(this.event.value).subscribe(
      (response) => {
        console.log("nice event");
      },
      (error) => {
        console.log("error event");
      },
    );
    if(this.event.value.haveImage){
      this.onUpload();
    }  
  }
  showReward(){
    this.reward = true;
  }
  hideReward(){
    this.reward = false;
  }
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }
}
