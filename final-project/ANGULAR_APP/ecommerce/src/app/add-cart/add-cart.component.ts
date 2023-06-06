import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-add-cart',
  templateUrl: './add-cart.component.html',
  styleUrls: ['./add-cart.component.css']
})
export class AddCartComponent implements OnInit {

  addCartList:any = [];
  totalAmt = 0.0;
  //integrate the api
  //bind the cart response in the ui
  constructor(private common:CommonService,private router:Router) {
    this.getCart();
   }
   navigateToCheckoutPage(){
    //before checkout should check the cart items.
    //navigate to checkout page.
    this.router.navigateByUrl("checkout");
   }
  ngOnInit(): void {
  }
  getCart(){    
    this.common.getHttp("cart/getByUserId/"+this.common.getUserId()).subscribe(res=>{
      this.addCartList = res;    
      //extracting the price and qty for total price.
      this.totalAmt = this.addCartList.map((cartObj:any)=>cartObj['price']*cartObj['qty']).reduce((acc:number, cur:number) => acc + cur);
    })
  }

}
