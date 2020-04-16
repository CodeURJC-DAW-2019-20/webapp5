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
  private page: number = 0;
  private merchList: any[];

  constructor(protected merchService: MerchService) { }

  ngOnInit(): void {
    this.getMerchList();
  }

  private handleError(error: any) {
		console.error(error);
  }

  private getMerchList(){
    this.merchService.getMerchPage(this.page).subscribe(
      data => {
      this.merchList = data['content'];
      this.page = this.page+1;
      console.log(data);
    },
    error => this.handleError(error)
    )
  }

}
