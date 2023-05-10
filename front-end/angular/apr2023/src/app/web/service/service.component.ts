import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  businessActions:any=[];
  constructor(private common:CommonService,private httpClient:HttpClient) {
    //this.businessActions = this.common.getBusinessActions();
    this.getBusinessActions();
   }

  ngOnInit(): void {
  }
  getBusinessActions(){
    this.httpClient.get("http://localhost:8080/getBusinessAction").subscribe(res=>{
      this.businessActions = res;
    },err=>{
      alert("Error while connect the rest api");
      console.log(err);
    })
  }

}
