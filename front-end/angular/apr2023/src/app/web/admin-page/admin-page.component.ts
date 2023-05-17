import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CONSTANTS } from 'src/app/CONSTANTS';
import { environment } from 'src/environments/environment';

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
    let url = environment.url;
    console.log("env url is ",url);
    this.getContactMessage();
    this.getBusinessActionsList();
  }
  saveBusinessAction(){
    let params = {"title":this.form.title,"description":this.form.message};
    this.httpClient.post(CONSTANTS.API_ENDPOINT+"saveBusinessAction",params).subscribe(res=>{
      this.getBusinessActionsList();//referesh the list.
    })
  }
  getContactMessage(){
      this.httpClient.get(CONSTANTS.API_ENDPOINT+"getAllContactMessages").subscribe(res=>{
          this.contactMessageList = res;
      })
  }
  getBusinessActionsList(){
    this.httpClient.get(CONSTANTS.API_ENDPOINT+"getBusinessAction").subscribe(res=>{        
        this.businessActionList = res;
    })
  }
  deleteBusinessAction(businessActionObj:any){
    if(!confirm("Are you sure want to delete")){
      return;
    }
    let params = {"id":businessActionObj.id};
    this.httpClient.post(CONSTANTS.API_ENDPOINT+"deleteBusinessAction",params).subscribe(res=>{
      this.getBusinessActionsList();//referesh the list.
    })
  }
}
