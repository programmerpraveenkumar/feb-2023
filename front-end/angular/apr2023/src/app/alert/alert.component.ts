import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {
  isShow = true;
  @Input() errorMessage = "";
  constructor() {
    console.log(this.errorMessage)
   }

  ngOnInit(): void {
  }

  closeDialog(){
    this.errorMessage  = "";
  }
}
