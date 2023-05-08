import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {
  // errorMessage is coming from parent
  @Input() errorMessage = "";
  constructor() {
   // console.log(this.errorMessage)
   }

  ngOnInit(): void {
  }

  closeDialog(){
    //while closing clearing the error message
    this.errorMessage  = "";
  }
}
