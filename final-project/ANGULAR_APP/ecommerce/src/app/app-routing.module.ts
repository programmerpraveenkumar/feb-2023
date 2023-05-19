import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { AddCartComponent } from './add-cart/add-cart.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { LoginRegisterComponent } from './login-register/login-register.component';

//localhost:4200/product
const routes: Routes = [
  {path:'',component:ProductListComponent},
  {path:'productList',component:ProductListComponent},  
  {path:'productDetails',component:ProductDetailsComponent},
  {path:'addcart',component:AddCartComponent},
  {path:'checkout',component:CheckoutComponent},
  {path:'orderHistory',component:OrderHistoryComponent},
  {path:'loginRegister',component:LoginRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
