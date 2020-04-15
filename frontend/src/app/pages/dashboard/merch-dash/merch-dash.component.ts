import { Component, OnInit } from '@angular/core';
import { PurchasesService } from 'src/app/services/purchases/purchases.service';

@Component({
  selector: 'app-merch-dash',
  templateUrl: './merch-dash.component.html',
  styleUrls: ['./merch-dash.component.css']
})
export class MerchDashComponent implements OnInit {

  public lastYearPurchases: any;
  public purchaseList: any;
  
  constructor(
    private purchaseService: PurchasesService
  ) { }

  ngOnInit(): void {
    this.getPurchasesByMonthChartData();
    this.getPurchaseTableData();
  }

  getPurchasesByMonthChartData(){
    this.purchaseService.getPurchaseLastYearList().subscribe(
      lastYearPurchases => {
        console.log(lastYearPurchases);
        this.lastYearPurchases = lastYearPurchases;
      },
      error => {
        console.log("La liaste pardisima");
      }
    );
  }

  getPurchaseTableData(){
    this.purchaseService.getPurchaseList().subscribe(
      purchaseList => {
        console.log(purchaseList);
        this.purchaseList = purchaseList;
      },
      error => {
        console.log("La liaste pardisima");
      }
    );
  }


}
