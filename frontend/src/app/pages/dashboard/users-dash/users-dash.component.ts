import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { RolesService } from 'src/app/services/roles/roles.service';

@Component({
  selector: 'app-users-dash',
  templateUrl: './users-dash.component.html',
  styleUrls: ['./users-dash.component.css']
})
export class UsersDashComponent implements OnInit {

  constructor(
    private userService: UsersService,
    private rolesService: RolesService,
  ) { }

  ngOnInit(): void {
    //getPurchasesByMonthChartData();
    //getPurchaseTableData();
  }

  getPurchasesByMonthChartData(){
    this.userService.getUsers().subscribe(
      usersList => {

      },
      error => {

      }
    );
  }

  getPurchaseTableData(){
    this.rolesService.getRoles().subscribe(
      rolesList => {

      },
      error => {

      }
    );
  }

}
