import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import { RolesService } from 'src/app/services/roles/roles.service';

@Component({
  selector: 'app-users-dash',
  templateUrl: './users-dash.component.html',
  styleUrls: ['./users-dash.component.css']
})
export class UsersDashComponent implements OnInit {

  public usersList: any;
  public rolesList: any;

  constructor(
    private userService: UsersService,
    private rolesService: RolesService,
  ) { }

  ngOnInit(): void {
    this.getPurchasesByMonthChartData();
    this.getPurchaseTableData();
  }

  getPurchasesByMonthChartData(){
    this.userService.getUsers().subscribe(
      usersList => {
        console.log(usersList);
        this.usersList = usersList;
      },
      error => {
        console.log("La liaste pardisima");
      }
    );
  }

  getPurchaseTableData(){
    this.rolesService.getRoles().subscribe(
      rolesList => {
        console.log(rolesList);
        this.rolesList = rolesList;
      },
      error => {
        console.log("La liaste pardisima");
      }
    );
  }

  setUserRole(){
    this.userService.setUserRole().subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log("La liaste pardisima");
      }
    );
  }

}
