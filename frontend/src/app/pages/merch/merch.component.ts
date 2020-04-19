import { Component, OnInit } from '@angular/core';

import { Merch } from '../../interfaces/merch';

import { MerchService } from '../../services/merch/merch.service';



@Component({
  selector: 'app-merch',
  templateUrl: './merch.component.html',
  styleUrls: ['./merch.component.css']
})
export class MerchComponent implements OnInit {

  //private merch: Merch;
  page: number = 0;
  merchList: Merch[];
  merchListAux: Merch[];
  lastPage: boolean = true;




  constructor(protected merchService: MerchService) { }

  ngOnInit(): void {
    this.getMerchList();
  }

  private handleError(error: any) {
		console.error(error);
  }

  getMerchList(){
    this.merchService.getMerchPage(this.page).subscribe(
      data => {
      this.merchList = (data['content']);
      this.page = this.page + 1;
      console.log(data);
    },
    error => this.handleError(error)
    )
  }

  getNewMerchList(){
    this.merchService.getMerchPage(this.page).subscribe(
      data => {
      if(data['empty'] == false){
      this.merchListAux = (data['content']);
      this.merchList = this.merchList.concat(this.merchListAux);
      this.page = this.page + 1;
      if(data['last']==true){
        this.lastPage = false
      }
    }
      console.log(data);
    },
    error => this.handleError(error)
    )
  }
}
