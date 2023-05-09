import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  businessActions:any=[];
  constructor(private common:CommonService) {
    this.businessActions = this.common.getBusinessActions();//callling the service method to get the data.
   }

  ngOnInit(): void {
  }

}
