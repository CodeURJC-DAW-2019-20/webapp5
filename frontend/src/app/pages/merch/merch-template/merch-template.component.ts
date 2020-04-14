import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Merch } from '../../../interfaces/merch';
import { MerchService } from '../../../services/merch/merch.service';
import { faBoxOpen, faCog, faCalculator, faPercent, faMoneyBillWave } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-merch-template',
  templateUrl: './merch-template.component.html',
  styleUrls: ['./merch-template.component.css']
})
export class MerchTemplateComponent implements OnInit {
  Merch: any;
  faBoxOpen = faBoxOpen;
  faCog = faCog;
  faCalculator = faCalculator;
  faPercent = faPercent;
  faMoneyBillWave = faMoneyBillWave;

  thumbnail: any;

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

  private refreshMerchImage() {
    this.merchService.getMerchImage().subscribe(
			response => this.Merch = response as any,
			error => this.handleError(error)
		);
  }
  
  private handleError(error: any) {
		console.error(error);
	}

}
