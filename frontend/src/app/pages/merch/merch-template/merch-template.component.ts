import { Component, OnInit } from '@angular/core';

import { Merch } from 'src/app//interfaces/merch';
import { MerchType } from 'src/app//interfaces/merch-type';

import { MerchService } from 'src/app/services/merch/merch.service';
import { PurchasesService } from 'src/app/services/purchases/purchases.service';
import { MerchTypeService } from 'src/app/services/merch-type/merch-type.service';

import { faBoxOpen, faCog, faCalculator, faPercent, faMoneyBillWave } from '@fortawesome/free-solid-svg-icons';
import { ActivatedRoute } from "@angular/router";

import { LocalStorage } from 'ngx-webstorage';


@Component({
  selector: 'app-merch-template',
  templateUrl: './merch-template.component.html',
  styleUrls: ['./merch-template.component.css']
})
export class MerchTemplateComponent implements OnInit {

  //merch var
  merch: Merch;
  merchType: MerchType;
  merchId: number;
  activatedRoute: ActivatedRoute;

  @LocalStorage('isUserLogged')
  public isUserLogged;

  @LocalStorage('currentUser')
  public currentUser;


  //icon var
  public faBoxOpen = faBoxOpen;
  public faCog = faCog;
  public faCalculator = faCalculator;
  public faPercent = faPercent;
  public faMoneyBillWave = faMoneyBillWave;

  //img var
  public imageToShow: any;
  public isImageLoading: boolean;

  constructor(protected purchaseService: PurchasesService, protected merchService: MerchService, protected merchTypeService: MerchTypeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.merchId = this.route.snapshot.queryParams['id'];
    //console.log(this.route.snapshot.queryParams);
    this.refreshMerch();
    console.log(this.merch);
    //this.refreshMerchType();
    console.log(this.merchType);
    this.getImageFromService();
  }

  private refreshMerch() {
    this.merchService.getMerch(this.merchId).subscribe(
      response => {this.merch = response as Merch;
      console.log(this.merch)},
			error => this.handleError(error)
    );
  }

  private refreshMerchType() {
    this.merchTypeService.getMerchType().subscribe(
			response => this.merchType = response as MerchType,
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
       this.merchService.getImage(this.merchId).subscribe(data => {
         this.createImageFromBlob(data);
         this.isImageLoading = false;
       }, error => {
         this.isImageLoading = false;
         console.log(error);
       });
   }

   
  buyMerch(){
    if(this.merch.stock != 0){
        this.merch.stock = this.merch.stock - 1;
        this.purchaseService.postPurchase(this.merch.id).subscribe(
          data => {
            console.log(data);
        }, error => {
          console.log(error);
        });
    }
  }


}
