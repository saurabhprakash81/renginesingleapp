import { Component, OnInit,ViewChild } from '@angular/core';
import { UserService } from '../_services/user.service';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  @ViewChild('f') form: any;

  rows= [];

  constructor(private userService: UserService) {

   }

  ngOnInit(): void {

    this.userService.getCategory().subscribe(
      data => {
        this.rows = data.departmentList;
        console.log("api response " + this.rows);
      },
      err => {
        this.rows = JSON.parse(err.error).message;
      }
    );

  }


   fetch(cb) {
    const req = new XMLHttpRequest();
    req.open('GET', `assets/data/categories.json`);

    req.onload = () => {
      cb(JSON.parse(req.response));
    };

    req.send();
  }
  

  onNgModelChange(e) { // here e is a boolean, true if checked, otherwise false
    if(e){
      // do something here
      console.log(e)
    }
  }  
  
  onSubmit(){

    var request: any = {};
    request.departmentList = this.rows;

    console.log(request);
    this.userService.postCategory(request).subscribe(
      data => {
        this.rows = data.departmentList;
        console.log("api response " + data);
      },
      err => {
        this.rows = JSON.parse(err.error).message;
      }
    );
    
  }

  updateValues(e : any) { // here e is a native event
    console.log(e.target.value);
    //console.log(this.form);

    let clickedComponent = e.target.value;
    let clickedComponentIndex = clickedComponent.split("_")[1];
    if(clickedComponent.indexOf("dep") != -1){
      this.rows.map(function(row){
        
        if(row.departmentId == clickedComponentIndex){

          row.categoryList.map(function(cat){

            if(e.target.checked){
              cat.selected=true;
              cat.disabled=true;

              } else {
                cat.selected=false;
                cat.disabled=false;

              }            


              cat.subCategoriesList.map(function(sub){
                if(e.target.checked){
                sub.selected=true;
                sub.disabled=true;

                sub.itemClassList.map(function(item){
                  item.selected=true;
                  item.disabled=true;
                })

                } else {
                  sub.selected=false;
                  sub.disabled=false;
                  sub.itemClassList.map(function(item){
                    item.selected=false;
                    item.disabled=false;
                  })
                }
              })
        })
      }
      })
    }
    if(clickedComponent.indexOf("cat") != -1){
      this.rows.map(function(row){
        
          row.categoryList.map(function(cat){
            
            if(cat.categoryId == clickedComponentIndex){
              cat.subCategoriesList.map(function(sub){
                if(e.target.checked){
                sub.selected=true;
                sub.disabled=true;

                sub.itemClassList.map(function(item){
                  item.selected=true;
                  item.disabled=true;
                })

                } else {
                  sub.selected=false;
                  sub.disabled=false;
                  sub.itemClassList.map(function(item){
                    item.selected=false;
                    item.disabled=false;
                  })
  

                }
              })
            }           
        
        })
      })
    }
    if(clickedComponent.indexOf("sub") != -1){
      this.rows.map(function(row){
        
          row.categoryList.map(function(cat){
            
            
              cat.subCategoriesList.map(function(sub){
                if(sub.subCategoryId == clickedComponentIndex){

                  sub.itemClassList.map(function(item){

                    if(e.target.checked){

                    item.selected=true;
                    item.disabled=true;
                    } else {
                      item.selected=false;
                      item.disabled=false;
  
                    }
                  })
                    }
              })
        })
      })
    }
}


}
