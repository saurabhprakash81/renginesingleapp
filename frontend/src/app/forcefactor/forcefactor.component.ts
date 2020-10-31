import { Component, OnInit,ViewChild } from '@angular/core';
import {DatatableComponent,ColumnMode} from '@swimlane/ngx-datatable';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-forcefactor',
  templateUrl: './forcefactor.component.html',
  styleUrls: ['./forcefactor.component.css']
})
export class ForceFactorComponent implements OnInit {

  constructor(private userService: UserService) {
      // this.fetch(data => {

      //   // cache our list
      //   this.temp = [...data];
  
      //   this.rows = data;
      // });
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
     this.userService.getForceFactors().subscribe(
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


  fetch(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `assets/data/forcefactor.json`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }

  updateValue(event, cell, rowIndex) {
    console.log('inline editing rowIndex', rowIndex);
    this.editing[rowIndex + '-' + cell] = false;
    this.rows[rowIndex][cell] = event.target.value;
    this.rows = [...this.rows];
    console.log('UPDATED!', this.rows[rowIndex][cell]);
  }

  getRowClass(row) {
    return {
      'odd-even-cell': row.recordId % 2 === 0
    };
  }

  updateFilter(event) {
    const val = event.target.value.toLowerCase();

    // filter our data
    const temp = this.temp.filter(function (d) {
      return d.forceFactorName.toLowerCase().indexOf(val) !== -1 || !val;
    });

    // update the rows
    this.rows = temp;
    // Whenever the filter changes, always go back to the first page
    this.table.offset = 0;
  }

  onSubmit(){
    
    this.userService.postForceFactors(this.rows).subscribe(
      data => {
        this.rows = data;
        console.log("api response " + data);
      },
      err => {
        this.rows = JSON.parse(err.error).message;
      }
    );
    //console.log('Invoked with '+this.rows.map(record => {
     // console.log('Item Key -> '+record.itemKey);
      //console.log('Item Recommendation -> '+record.recommended);
    //}));
    
  }

}
