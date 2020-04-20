import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MerchService } from 'src/app/services/merch/merch.service';
import { MerchTypeService } from 'src/app/services/merch-type/merch-type.service';
import { MerchType } from 'src/app/interfaces/merch-type';
import { throwError, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { LocalStorage } from 'ngx-webstorage';

@Component({
  selector: 'app-merch-form',
  templateUrl: './merch-form.component.html',
  styleUrls: ['./merch-form.component.css']
})
export class MerchFormComponent implements OnInit {

  @LocalStorage('isUserAdmin')
  public isUserAdmin;


public merch;
merTypeList: MerchType[];
selectedFile: File;
receivedImageData: any;
merchNumber: number;
merchCreated;

  constructor(private httpClient: HttpClient, public merchService: MerchService, public merTypeService: MerchTypeService,public router: Router) {
    this.createMerch();
  }

  ngOnInit(): void {
    if(!this.isUserAdmin){
      this.router.navigate(['/error']);
    }
    this.createMerchTypeList();
  }
  
  public onFileChanged(merch) {
    this.selectedFile = merch.target.files[0];
    this.merch.controls['haveImage'].setValue(true);
  }

  private createMerch(){
    this.merch = new FormGroup({
      name: new FormControl(null, Validators.required),
      haveImage: new FormControl(false),
      type: new FormControl(null, Validators.required),
      description: new FormControl(null,Validators.required),
      stock: new FormControl(null,Validators.required),
      discount: new FormControl(null,Validators.required),
      price: new FormControl(null,Validators.required)
    });
  }
 // upload image of the new merch
 uploadImage() {
  const uploadImageData = new FormData();
  uploadImageData.append('imageFile', this.selectedFile);
  this.merchService.saveImage(this.merchNumber,uploadImageData).subscribe(
    (response) => {
    },
    (error) => {
      console.error(error);
    },
  );
}
  //upload a new merch
  submit(){    
    this.merchService.saveMerch(this.merch.value).subscribe(
      (response) => {
        this.merchCreated = response;
        this.merchNumber = this.merchCreated.id;
        this.router.navigate(['/merch-template'],{ queryParams: { id: this.merchNumber}});
        if(this.merch.value.haveImage){
          this.uploadImage();
        } 
      },
      (error) => {
        console.error(error);
      },
    );
     
  }

  private createMerchTypeList(){
    this.merTypeService.getMerchTypes().subscribe(
      response => {
        this.merTypeList = response as MerchType[];
      },
      error => this.handleError(error)
    );
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error);
  }
}
