import { Component, OnInit } from '@angular/core';

import { MerchService } from '../../services/merch/merch.service';

@Component({
  selector: 'app-merch',
  templateUrl: './merch.component.html',
  styleUrls: ['./merch.component.css']
})
export class MerchComponent implements OnInit {

  Merch: any;

  constructor(protected merchService: MerchService) { }

  ngOnInit(): void {
    this.refreshMerch();
  }

  private refreshMerch() {
    this.merchService.getMerch().subscribe(
			response => this.Merch = response as any,
			error => this.handleError(error)
    );
  }

  private handleError(error: any) {
		console.error(error);
  }

}
