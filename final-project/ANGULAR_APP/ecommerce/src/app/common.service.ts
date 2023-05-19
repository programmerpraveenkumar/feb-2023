import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  baseURl = "http://localhost:8080/";
  constructor(private http:HttpClient) { }
  getBaseUrl(){
    return this.baseURl;
  }
  getHttp(endpoint:string){
    return this.http.get(this.baseURl+endpoint)
  }
  postHttp(endpoint:string,params:any){
    return this.http.get(this.baseURl+endpoint,params);
  }
}
export interface productDetails{
  name:string,
  category_id:number,
  created_date:string,
  description:string,
  discount:number,
  id:number,
  price:number
}