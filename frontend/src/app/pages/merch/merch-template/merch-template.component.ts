import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://127.0.0.1:8080/merchs/';

@Component({
  selector: 'app-merch-template',
  templateUrl: './merch-template.component.html',
  styleUrls: ['./merch-template.component.css']
})
export class MerchTemplateComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {

  }

}
