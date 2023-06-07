import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  addProduct(){
    //api to create product
  }
  getProductByCategoryId(){
    //get the proudct list based onthe category
  }
}
