import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-web-header',
  templateUrl: './web-header.component.html',
  styleUrls: ['./web-header.component.css']
})
export class WebHeaderComponent implements OnInit {
  @Input() currentMenu = "";
  constructor() { }

  ngOnInit(): void {
  }

}
