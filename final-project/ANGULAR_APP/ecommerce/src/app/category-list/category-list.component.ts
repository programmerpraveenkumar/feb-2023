import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categoryList:any = [{name:""}];
  pageName = "category";
  @Output() selectedCateory = new EventEmitter();
  constructor(private common:CommonService) { 
    this.getCategoryList();
  }

  ngOnInit(): void {
  }
  selectCategory(categoryObj:any){
    this.selectedCateory.emit(categoryObj.id);
  }
  //localhost:8080/category/get
getCategoryList(){
  this.common.getHttp("category/get").subscribe(res=>{    
    this.categoryList = res;
  })
}
}
