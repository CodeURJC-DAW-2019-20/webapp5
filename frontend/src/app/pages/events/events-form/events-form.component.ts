import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-events-form',
  templateUrl: './events-form.component.html',
  styleUrls: ['./events-form.component.css']
})
export class EventsFormComponent implements OnInit {

  public event;
  gamesList: string[]=["1","2","3"];
  public flag: boolean;
  selectedFile: File;
  receivedImageData: any;


  constructor(private httpClient: HttpClient, public eventService: EventsService) {
    this.createEvent();
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }

  private createEvent(){
    
    this.event = new FormGroup({
      name: new FormControl(null,Validators.required),
      game: new FormControl(null,Validators.required),
      place: new FormControl(null,Validators.required),
      day: new FormControl(null,Validators.required),
      hour: new FormControl(null,Validators.required),
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
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile);
    //Make a call to the Spring Boot Application to save the image
    this.eventService.saveImage(57,uploadImageData).subscribe(
      (response) => {
        console.log("nice");
      },
      (error) => {
        console.log("error");
      },
    );
  }

  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
    this.flag = false;
  }

  submit(){
    console.log(this.event.value);
    this.eventService.saveEvent(this.event.value).subscribe(
        
      (error: Error) => console.error('Error creating new book: ' + error),
      
    );

    //this.onUpload();
  }
  showReward(){
    this.flag = true;
  }
  hideReward(){
    this.flag = false;
  }

}
