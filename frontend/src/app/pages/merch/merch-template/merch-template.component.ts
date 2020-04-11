import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Merch } from '../../../interfaces/merch';

const BASE_URL = 'https://localhost:8443/api/merchandisings/38';

@Component({
  selector: 'app-merch-template',
  templateUrl: './merch-template.component.html',
  styleUrls: ['./merch-template.component.css']
})
export class MerchTemplateComponent implements OnInit {

  Merch;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
		this.refresh();
  }

  private refresh() {
		this.httpClient.get(BASE_URL).subscribe(
			response => this.Merch = response as any,
			error => this.handleError(error)
		);
  }
  
  private handleError(error: any) {
		console.error(error);
	}

}
