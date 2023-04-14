import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonService } from '../common.service';

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
  //constructor injection
  constructor(private http:HttpClient,private common:CommonService ) { }

  ngOnInit(): void {
  }
  
  getHttpResponse(){
    this.http.get("https://reqres.in/api/users?page="+this.pageNo).subscribe((res:any)=>{
      console.log(res);
      this.userList = res['data'];
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

}
