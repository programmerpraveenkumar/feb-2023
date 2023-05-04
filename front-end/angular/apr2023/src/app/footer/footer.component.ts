import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  @Output() toParent = new EventEmitter();//sending data to parent
  constructor(private common:CommonService) { }

  ngOnInit(): void {
  }
  sendDataToParent(){
    this.toParent.emit("from footer");
  }

  publishMessage(){
    this.common.eventService.next("from footer to other components");
  }

}
