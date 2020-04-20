import { Component, OnInit, Input } from '@angular/core';
import { ChartType, ChartDataSets, ChartOptions } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-merch-line-chart',
  templateUrl: './merch-line-chart.component.html',
  styleUrls: ['./merch-line-chart.component.css']
})
export class MerchLineChartComponent implements OnInit {

  @Input()
  width: any = 900;

  @Input()
  height: any = 380;

  @Input()
  data: any;

  charType: ChartType = 'line';
  labels: Label[] = [];
  datasets: ChartDataSets[] = [
    {
      data: [],
      lineTension: 0,
      backgroundColor: 'transparent',
      borderColor: '#a10600',
      borderWidth: 4,
      pointBackgroundColor: '#a10600',
      pointBorderColor: '#a10600',
      pointHoverBackgroundColor: '#a10600',
      pointHoverBorderColor: '#a10600'
    }
  ];
  options: ChartOptions = {
    scales: {
      xAxes: [{}],
      yAxes:[{
        ticks:{
          beginAtZero: true,
          stepSize: 1
        }
      }]
    },
    legend: {
      display: false,
    }
  }

  constructor() { }

  ngOnInit(): void {
    this.fillData();
  }

  fillData(){
    setTimeout(() => {
      if(this.data[0] == undefined || this.data[1] == undefined){
        this.fillData();
      } else {
        this.labels = this.data[0];
        this.datasets =  [
          { data: this.data[1], }
        ];
      }
      
    }, 10)
  }

}
