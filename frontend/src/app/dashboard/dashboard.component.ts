import { Component, OnInit,ViewChild } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import {Router} from '@angular/router';
import {DatatableComponent,ColumnMode} from '@swimlane/ngx-datatable';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private authService: AuthService, private router:Router,
    private tokenStorage: TokenStorageService,private userService: UserService) {
      //  this.fetch(data => {

      //    // cache our list
      //    this.temp = [...data];
      //    console.log("hard coded data" + data);
  
      //    this.rows = data;
      //  });
     }

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  ngOnInit() {
    
    // if (this.tokenStorage.getToken()) {
    //   //alert("hi");
    //   this.isLoggedIn = true;
    //   this.roles = this.tokenStorage.getUser().roles;
    //   //this.reloadPage();
    // }
     this.userService.getDashBoard().subscribe(
       data => {
         this.rows = data;
         console.log("api response " + data);
       },
       err => {
         this.rows = JSON.parse(err.error).message;
       }
     );
  }

  reloadPage(): void {
    window.location.reload();
  }


  editing = {};
  rows = [];
  temp = [];
  @ViewChild(DatatableComponent) table: DatatableComponent;
  @ViewChild('f') form: any;


  ColumnMode = ColumnMode;


 /* fetch(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `assets/data/dashboard-data.json`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  } */

  updateValue(event, cell, rowIndex) {
    console.log('inline editing rowIndex', rowIndex);
    this.editing[rowIndex + '-' + cell] = false;
    this.rows[rowIndex][cell] = event.target.value;
    this.rows = [...this.rows];
    console.log('UPDATED!', this.rows[rowIndex][cell]);
  }

  getRowClass(row) {
    return {
      'odd-even-cell': row.id % 2 === 0
    };
  }

  updateFilter(event) {
    const val = event.target.value.toLowerCase();

    // filter our data
    const temp = this.temp.filter(function (d) {
      return d.itemName.toLowerCase().indexOf(val) !== -1 || !val;
    });

    // update the rows
    this.rows = temp;
    // Whenever the filter changes, always go back to the first page
    this.table.offset = 0;
  }

  onSubmit(){

    this.userService.postDashBoard(this.rows).subscribe(
      data => {
        this.rows = data;
        console.log("api response " + data);
      },
      err => {
        this.rows = JSON.parse(err.error).message;
      }
    );
    // console.log('Invoked with '+this.rows.map(record => {
    //   console.log('Item Key -> '+record.itemKey);
    //   console.log('Item Recommendation -> '+record.recommended);
    // }));
    
  }

}
