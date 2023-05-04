import { Component, Input, OnInit } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() fromParent ="";//value is coming from the parent component.
  constructor(private common:CommonService) {
    this.common.eventService.subscribe(res=>{
      console.log("message from the publisher..",res);
    })
   }
  ngOnInit(): void {
  }

}
