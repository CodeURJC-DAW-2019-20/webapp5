import { Component, OnInit, Input } from '@angular/core';
import { ChartType, ChartDataSets, ChartOptions } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-events-bar-chart',
  templateUrl: './events-bar-chart.component.html',
  styleUrls: ['./events-bar-chart.component.css']
})
export class EventsBarChartComponent implements OnInit {

  @Input()
  width: any = 900;

  @Input()
  height: any = 380;

  @Input()
  data: any;

  charType: ChartType = 'bar';
  labels: Label[] = [];
  datasets: ChartDataSets[] = [
    { data: [] }
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
