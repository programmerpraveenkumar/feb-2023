import { Component, OnInit } from '@angular/core';
import { CommonService, productDetails } from '../common.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']  
})
export class ProductDetailsComponent implements OnInit {
  productDetail:productDetails={'name':'','price':0.0,'category_id':0,'created_date':'','description':'','id':0,'discount':0.0};
  qty = 0;
  constructor(private common:CommonService,private activatedRoute:ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(res=>{
      this.getProductById(res['product_id']);
    })    
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
    if(this.qty<=0){
      alert("please enter the qty");
      return;
    }
    let params = {
      "user_id":this.common.getUserId(),
      "product_id":this.productDetail.id,
      "qty":this.qty
    }
    this.common.postHttp("cart/save",params).subscribe(res=>{
      alert("Cart Added SuccessFully")
      console.log(res);
    },err=>{
      console.log(err);
      alert("Error while adding cart");
    })
  }
}
