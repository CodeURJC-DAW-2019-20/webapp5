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
    this.getUserTableData();
    this.getRoleData();
  }

  getUserTableData(){
    this.userService.getUsers().subscribe(
      usersList => {
        this.usersList = usersList;
      },
      error => {
        console.error(error);
      }
    );
  }

  getRoleData(){
    this.rolesService.getRoles().subscribe(
      rolesList => {
        this.rolesList = rolesList;
      },
      error => {
        console.error(error);
      }
    );
  }

  setUserRole(userId, roleId){
    this.userService.setUserRole(userId, roleId).subscribe(
      response => {
      },
      error => {
        console.error(error);
      }
    );
  }

  deleteUser(userId){
    this.userService.deleteUser(userId).subscribe(
      response => {
        this.getUserTableData();
      },
      error => {
        console.error(error);
      }
    );
  }

}
