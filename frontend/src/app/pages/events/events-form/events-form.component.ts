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

  //event;
  gamesList: string[]=["1","2","3"];
  public flag: boolean;

  public selectedFile;
  public event1;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  constructor(private httpClient: HttpClient) {
    /*this.event = new FormGroup({
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
    });*/ 
  }


  public  onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
  };

 }


 // This part is for uploading
 onUpload() {


  const uploadData = new FormData();
  uploadData.append('myFile', this.selectedFile, this.selectedFile.name);


  this.httpClient.post('http://localhost:8080/check/upload', uploadData)
  .subscribe(
               res => {console.log(res);
                       this.receivedImageData = res;
                       this.base64Data = this.receivedImageData.pic;
                       this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data; },
               err => console.log('Error Occured duringng saving: ' + err)
            );


 }




  ngOnInit(): void{
    //this.event = this.EventsService.getItems();
    this.flag = false;
  }

  submit(){
    //this.name = name;
    //this.service.saveEvent(this.event);
    
    //console.log(this.event.value);
  }
  showReward(){
    this.flag = true;
  }
  hideReward(){
    this.flag = false;
  }

}
