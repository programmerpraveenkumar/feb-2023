import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {
  contactMessageList:any=[];
  businessActionList:any=[];
  form = {"title":"", "message":""}
  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    this.getContactMessage();
    this.getBusinessActionsList();
  }
  postContactMessage(){
    let params = {"title":this.form.title,"description":this.form.message};
    this.httpClient.post("http://localhost:8080/saveBusinessAction",params).subscribe(res=>{
      this.getBusinessActionsList();//referesh the list.
    })
  }
  getContactMessage(){
      this.httpClient.get("http://localhost:8080/getAllContactMessages").subscribe(res=>{
          this.contactMessageList = res;
      })
  }
  getBusinessActionsList(){
    this.httpClient.get("http://localhost:8080/getBusinessAction").subscribe(res=>{        
        this.businessActionList = res;
    })
  }
  deleteBusinessAction(businessActionObj:any){
    if(!confirm("Are you sure want to delete")){
      return;
    }
    let params = {"id":businessActionObj.id};
    this.httpClient.post("http://localhost:8080/deleteBusinessAction",params).subscribe(res=>{
      this.getBusinessActionsList();//referesh the list.
    })
  }
}
