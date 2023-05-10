import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  businessActions:any=[];
  contactForm={"name":"","email":"","mobile":"","message":""};

  constructor(private common:CommonService,private httpClient:HttpClient) {
    //this.businessActions = this.common.getBusinessActions();//callling the service method to get the data.
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
  validateForm(){
    if(this.contactForm.name == ""){
      this.common.showAlert("Please Enter the name")
      return;
    }
    else if(this.contactForm.email == ""){
      this.common.showAlert("Please Enter the email")
      return;
    }
    else if(this.contactForm.message == ""){
      this.common.showAlert("Please Enter the messgae")
      return;
    }
    else if(this.contactForm.mobile == ""){
      this.common.showAlert("Please Enter the mobile")
      return;
    }else{
      let params = {
        "name":this.contactForm.name,
        "phoneNo":this.contactForm.mobile,
        "email":this.contactForm.email,
        "message":this.contactForm.message
      }
      this.common.saveContact(params).subscribe(res=>{
        alert("Stored Sucessfully");
        this.contactForm.name = "";
        this.contactForm.mobile = "";
        this.contactForm.email = "";
        this.contactForm.message = "";
      },err=>{
        alert("Error while storing");
      });
      //rest api
      //this.common.showAlert("everything is fine.");
    }
  }

}
