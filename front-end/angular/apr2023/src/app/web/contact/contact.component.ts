import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contactForm={"name":"","email":"","mobile":"","message":""};
  constructor(private common:CommonService) { }

  ngOnInit(): void {
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
      });;
      //rest api
      //this.common.showAlert("everything is fine.");
    }
  }

}
