import { Component, OnInit } from '@angular/core';

import { Merch } from '../../../interfaces/merch';
import { MerchType } from '../../../interfaces/merch-type';

import { MerchService } from '../../../services/merch/merch.service';
import { MerchTypeService } from '../../../services/merch-type/merch-type.service';

import { faBoxOpen, faCog, faCalculator, faPercent, faMoneyBillWave } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-merch-template',
  templateUrl: './merch-template.component.html',
  styleUrls: ['./merch-template.component.css']
})
export class MerchTemplateComponent implements OnInit {

  //merch var
  public merch: Merch;
  public merchType: MerchType;

  //icon var
  public faBoxOpen = faBoxOpen;
  public faCog = faCog;
  public faCalculator = faCalculator;
  public faPercent = faPercent;
  public faMoneyBillWave = faMoneyBillWave;

  //img var
  public imageToShow: any;
  public isImageLoading: boolean;

  constructor(protected merchService: MerchService, protected merchTypeService: MerchTypeService) { }

  ngOnInit(): void {
    this.refreshMerch();
    this.refreshMerchType();
    this.getImageFromService();
  }

  private refreshMerch() {
    this.merchService.getMerch().subscribe(
			response => this.merch = response as any,
			error => this.handleError(error)
    );
  }

  private refreshMerchType() {
    this.merchTypeService.getMerchType().subscribe(
			response => this.merchType = response as any,
			error => this.handleError(error)
    );
  }
  
  private handleError(error: any) {
		console.error(error);
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
       this.merchService.getImage().subscribe(data => {
         this.createImageFromBlob(data);
         this.isImageLoading = false;
       }, error => {
         this.isImageLoading = false;
         console.log(error);
       });
   }

}
