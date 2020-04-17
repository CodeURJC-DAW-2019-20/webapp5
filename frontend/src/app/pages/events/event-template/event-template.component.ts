import { Component, OnInit } from '@angular/core';
import { Events } from 'src/app/interfaces/events';
import { EventsService } from 'src/app/services/events/events.service';
import { throwError, Observable } from 'rxjs';
import { faClock, faMapMarkerAlt, faGamepad, faChild, faUsers, faMoneyBillWave, faBoxes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-event-template',
  templateUrl: './event-template.component.html',
  styleUrls: ['./event-template.component.css']
})
export class EventTemplateComponent implements OnInit {

 event: Events;
 imageToShow: any;
 isImageLoading: boolean;

  //icon var
  faClock = faClock;
  faMapMarkerAlt = faMapMarkerAlt;
  faGamepad = faGamepad;
  faChild = faChild;
  faUsers = faUsers;
  faMoneyBillWave = faMoneyBillWave;
  faBoxes = faBoxes;

  constructor(protected eventsService: EventsService) {    
   }

  ngOnInit(): void {
    this.refreshEvent();
    this.getImageFromService();
  }

  refreshEvent(){
    this.eventsService.getEvent(23).subscribe(
      response => {
        this.event = response as Events;
        console.log(this.event);
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

  private getImageFromService() {
    this.isImageLoading = true;
    this.eventsService.getImage(23).subscribe(data => {
      this.createImageFromBlob(data);
      this.isImageLoading = false;
    }, error => {
      this.isImageLoading = false;
      //this.imageToShow = 
      console.log(error);
    });
  }
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }
}
