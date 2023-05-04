import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  @Output() toParent = new EventEmitter();//sending data to parent
  constructor() { }

  ngOnInit(): void {
  }
  sendDataToParent(){
    this.toParent.emit("from footer");
  }

}
