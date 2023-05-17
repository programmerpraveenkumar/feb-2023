import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CategoryComponent } from './category/category.component';
import { ProductListComponent } from './product-list/product-list.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { AddCartComponent } from './add-cart/add-cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CategoryListComponent } from './category-list/category-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CategoryComponent,
    ProductListComponent,
    LoginRegisterComponent,
    AddCartComponent,
    CheckoutComponent,
    OrderHistoryComponent,
    ProductDetailsComponent,
    CategoryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
