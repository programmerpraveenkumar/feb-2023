import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommonService } from '../common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  inputName = "";
  mobileNumber = "";
  userList:any = [];
  pageNo = 1;
  someTxt = "sample";
  price  = 100;
  num  = 5;
  currentDate = new Date();
  response:any="";
  apiFieldName = "";
  apiFieldJob = "";
  erroResponse = "";
  registerForm={"name":"","mobile":"","address":""};
  errorMessageVal = "";
  //constructor injection
  constructor(private http:HttpClient,private common:CommonService,private router:Router ) { }

  ngOnInit(): void {
  }
  
  getHttpResponse(){
    this.http.get("https://reqres.in/api/users?page="+this.pageNo).subscribe((res:any)=>{
      console.log(res);
      this.userList = res['data'];
    })
  }
  getHttpError(){
    this.http.get("https://reqres.in/api/users/23").subscribe((res:any)=>{
      console.log(res);
    },err=>{
      console.log(err);
      this.erroResponse = err.status;
      this.common.showAlert("Error while fetching the user details");
    })
  }
  validateInput(){
    //this.common.showAlert();//alert will be shown from the service
    if(this.inputName == ""){
      this.common.showAlert("Please Enter the Name");
    }
    else if(this.mobileNumber == ""){
      this.common.showAlert("Please Enter the Mobile");
    }
  }
  navigateHome(){
    //navigation to home page.
    this.router.navigateByUrl('home');
  }
  postHttpRequest(){
    let httpHeader =  new HttpHeaders({
      'Content-Type':  'application/json',
      "token":"sample token"
    })
    if(this.apiFieldName == ""){
      //this.common.showAlert("Please Enter the Name");
      this.errorMessageVal = "Please Enter Name";
    }else if(this.apiFieldJob == ""){
      //this.common.showAlert("Please Enter the Job");
      this.errorMessageVal = "Please Enter Job";
    }

    let params = {
      "name": this.apiFieldName,
      "job": this.apiFieldJob
    }
    this.http.post("https://reqres.in/api/users",params,{headers:httpHeader}).subscribe((res:any)=>{
      console.log(res);
      this.response = res;
    })
  }

}
