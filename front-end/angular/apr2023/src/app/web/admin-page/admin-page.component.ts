import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {
  contactMessageList:any=[
    {"name":"asdfa","phnNo":"3434","email":"test@gmail.com","messgae":"sample message","date":"10-02-2025"},
    {"name":"asdfa","phnNo":"3434","email":"test1@gmail.com","messgae":"sample message","date":"10-02-2025"},
    {"name":"asdfa","phnNo":"3434","email":"test2@gmail.com","messgae":"sample message","date":"10-02-2025"},
    {"name":"asdfa","phnNo":"3434","email":"test3@gmail.com","messgae":"sample message","date":"10-02-2025"},
];
  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
  }
  getContactMessage(){
      this.httpClient.get("").subscribe(res=>{
          this.contactMessageList = res;
      })
  }

}
