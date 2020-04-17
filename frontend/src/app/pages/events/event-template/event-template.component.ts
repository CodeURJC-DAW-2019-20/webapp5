import { Component, OnInit } from '@angular/core';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';
import { throwError, Observable } from 'rxjs';
import { faClock, faMapMarkerAlt, faGamepad, faChild, faUsers, faMoneyBillWave, faBoxes } from '@fortawesome/free-solid-svg-icons';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-event-template',
  templateUrl: './event-template.component.html',
  styleUrls: ['./event-template.component.css']
})
export class EventTemplateComponent implements OnInit {

  event: Events;
  imageToShow: any;
  isImageLoading: boolean;
  eventNumber: number;
  isLogged: boolean;
  showRegisterEvent: boolean;
  public inscription;

  //icon var
  faClock = faClock;
  faMapMarkerAlt = faMapMarkerAlt;
  faGamepad = faGamepad;
  faChild = faChild;
  faUsers = faUsers;
  faMoneyBillWave = faMoneyBillWave;
  faBoxes = faBoxes;

  constructor(
    protected eventsService: EventsService,
    public loginService: LoginService,
    public router: Router
    ) { 
      this.inscription = new FormGroup({
        eventsReg: new FormControl(null,Validators.required)
      });
   }

  // on init, get the event data
  ngOnInit(): void {
    this.showRegisterEvent = false;
    //this.isLogged = this.loginService.isLogged;
    this.isLogged = true;
    if(this.isLogged){
      //this.router.navigate(['/error']);
    }
    this.refreshEvent();
  }

  //get the event data
  refreshEvent(){
    this.eventsService.getEvent(23).subscribe(
      response => {
        this.event = response as Events;
        this.eventNumber = this.event.id;
        this.getImageFromService();
      },
      error => this.handleError(error)
    );
  }

  private createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
       this.imageToShow = reader.result;
    }, false);
 
    if (image) {
       reader.readAsDataURL(image);
    }
   }

  //get the event image
  private getImageFromService() {
    this.eventsService.getImage(this.event.id).subscribe(data => {
      this.createImageFromBlob(data);
      this.isImageLoading = true;
    }, error => {
      this.isImageLoading = false;
      console.log(error);
    });
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }

  showRegister(){
    this.showRegisterEvent = true;
  }

  submit(){
    this.showRegisterEvent = false;
    console.log(this.showRegisterEvent);
    console.error(this.inscription.value.eventsReg);
    this.eventsService.saveInscription(this.event.id,this.inscription.value).subscribe(
      response => {
        console.log("register great");
      },
      error => this.handleError(error)
    );
  }
}
