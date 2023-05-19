import { Component, OnInit } from '@angular/core';
import { CommonService, productDetails } from '../common.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']  
})
export class ProductDetailsComponent implements OnInit {
  productDetail:productDetails={'name':'','price':0.0,'category_id':0,'created_date':'','description':'','id':0,'discount':0.0};

  constructor(private common:CommonService) {
    this.getProductById(1);
   }

  ngOnInit(): void {
  }
  getProductById(productId:any){
    this.common.getHttp("product/get/"+productId).subscribe((res:any)=>{
      console.log(res);
      this.productDetail = res;
    })
  }
  addCart(){
    //this.common.postHttp()
  }
}
