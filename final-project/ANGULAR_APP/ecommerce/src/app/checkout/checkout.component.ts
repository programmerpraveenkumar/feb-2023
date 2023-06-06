import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

 address= "";
  addCartList:any = [];
  totalAmt = 0.0;
  //integrate the api
  //bind the cart response in the ui
  constructor(private common:CommonService) {
    this.getCart();
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
  orderCart(){
    let params = {
      "user_id":this.common.getUserId(),
      "address":this.address
    }
    if(this.address == ""){
      alert("Please Enter Address");
      return;
    }
    this.common.postHttp("cart/orderComplete",params).subscribe(res=>{
      alert("Order completed");
    },err=>{
      console.log(err);  
      alert("Error while order!!!")
    })
  }
}
