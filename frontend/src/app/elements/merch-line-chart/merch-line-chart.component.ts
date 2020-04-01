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

  charType: ChartType = 'line';
  labels: Label[] = ['1', '2', '3', '4'];
  datasets: ChartDataSets[] = [
    {
      data: [5, 10, 7, 9],
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
  }

}
