import { Component, OnInit } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  //variable declaration.
  firstName:string = 'Contact sample name';
  form={"name":"","message":""}
  errorMessage = "";
  constructor(private common:CommonService) {
    this.common.eventService.subscribe(res=>{
      console.log("message from the publisher..",res);
    })
   }

  ngOnInit(): void {
  }
  recvFunction(data:any){
    console.log(data);
  }
  validateValues(){
    if(this.form.name == ""){
      this.errorMessage = "Please Enter Name";
    }
    else if(this.form.message == ""){
      this.errorMessage = "Please Enter Message";
    }
  }
  
}
