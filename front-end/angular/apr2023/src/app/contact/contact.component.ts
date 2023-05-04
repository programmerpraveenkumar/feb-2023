import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  //variable declaration.
  firstName:string = 'Contact sample name';

  constructor() { }

  ngOnInit(): void {
  }
  recvFunction(data:any){
    console.log(data);
  }
}
