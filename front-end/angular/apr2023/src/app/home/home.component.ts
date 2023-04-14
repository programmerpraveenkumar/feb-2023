import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  cssClassName = "redcolor";
  //variable declaration.
  firstName:string = 'sample name';
  lastName:string  = 'lastname sample';
  nameList=["asdfas","ertert","opioiu","sample name","another name"];
  isShow = true;
  isRed = true;
  nameAgeList=[{"name":"test1","age":15},
            {"name":"test2","age":25},
            {"name":"test3","age":30},
            {"name":"test4","age":35},
            {"name":"test5","age":45},
            {"name":"test6","age":55},

  ];

  constructor(private common:CommonService) { }
  showOrHideTheElement(){
    //`this` access global variable
    this.isShow = !this.isShow;
  }
  changeCssClass(cssClassNameArg:string){
      this.cssClassName = cssClassNameArg;
  }
  ngOnInit(): void {
  }
  cssClassIfCondition(){
    this.isRed = !this.isRed;
  }

}
