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

  charType: ChartType = 'bar';
  labels: Label[] = ['1', '2', '3', '4'];
  datasets: ChartDataSets[] = [
    { data: [5, 10, 7, 9] }
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
