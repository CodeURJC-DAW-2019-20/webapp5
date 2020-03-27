import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MapInfoWindow, MapMarker } from '@angular/google-maps';

@Component({
  selector: 'app-lcdd-map',
  templateUrl: './lcdd-map.component.html',
  styleUrls: ['./lcdd-map.component.css']
})
export class LcddMapComponent implements OnInit {

  @ViewChild(MapInfoWindow, { static: false }) infoWindow: MapInfoWindow
  
  @Input()
  height: any;

  @Input()
  width: any;
  
  zoom: any = 16;
  lcdd: google.maps.LatLngLiteral = {
    lat: 40.335270,
    lng: -3.877363,
  };;
  
  mapOptions: google.maps.MapOptions = {
    mapTypeControl: true,
    zoomControl: true,
    zoomControlOptions: {
      position: google.maps.ControlPosition.RIGHT_BOTTOM,
    },
    mapTypeControlOptions:{
      style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
      position: google.maps.ControlPosition.RIGHT_BOTTOM,
    },
    streetViewControl: false,
    rotateControl: false,
  }
  
  markerOptions: google.maps.MarkerOptions = {
    icon: '../../../assets/img/otros/geo_icon.png',
    animation: google.maps.Animation.DROP,
  }

  openInfoWindow(marker: MapMarker) {
    this.infoWindow.open(marker)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
