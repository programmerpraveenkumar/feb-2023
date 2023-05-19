import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonService, productDetails } from '../common.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {

  productDetailList:productDetails[] = [];
  constructor(private common:CommonService) { }

  ngOnInit(): void {
  }

  selectedCateoryFromCategory(categoryId:any){
    //console.log(categoryId);
    this.common.getHttp("product/get?categoryId="+categoryId).subscribe((res:any)=>{
      //console.log(res);
      this.productDetailList = res;
      console.log(this.productDetailList);
    })

  }

}
