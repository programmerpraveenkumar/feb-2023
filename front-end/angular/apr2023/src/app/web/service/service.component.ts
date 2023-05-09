import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  businessActions:any=[];
  constructor(private common:CommonService) {
    this.businessActions = this.common.getBusinessActions();
   }

  ngOnInit(): void {
  }
 

}
