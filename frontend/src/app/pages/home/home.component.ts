import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  styles: [`
  /deep/ .carousel-control-prev-icon{
    background-image: url("../../../assets/img/home/prevFOTO.png") !important;
    width: 50px !important;
    height: 50px !important;
  }
  /deep/ .carousel-control-next-icon{
    background-image: url("../../../assets/img/home/nextFOTO.png") !important;
    width: 50px !important;
    height: 50px !important;
  }
  /deep/ .carousel-control-next, /deep/ .carousel-control-prev{
    opacity: 1 !important;
    z-index: 100001 !important;
  }
`]
})
export class HomeComponent implements OnInit {

  public images = [1, 2, 3].map((n) => `../../../assets/img/home/home_page${n}.jpg`);

  constructor() { }

  ngOnInit(): void {
  }

}
