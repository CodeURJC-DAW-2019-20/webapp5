import { Component, OnInit } from '@angular/core';
import { PurchasesService } from 'src/app/services/purchases/purchases.service';

@Component({
  selector: 'app-merch-dash',
  templateUrl: './merch-dash.component.html',
  styleUrls: ['./merch-dash.component.css']
})
export class MerchDashComponent implements OnInit {

  constructor(
    private purchaseService: PurchasesService
  ) { }

  ngOnInit(): void {
    //getPurchasesByMonthChartData();
    //getPurchaseTableData();
  }

  getPurchasesByMonthChartData(){
    this.purchaseService.getPurchaseLastYearList().subscribe(
      lastYearPurchases => {

      },
      error => {

      }
    );
  }

  getPurchaseTableData(){
    this.purchaseService.getPurchaseList().subscribe(
      purchaseList => {

      },
      error => {

      }
    );
  }

}
