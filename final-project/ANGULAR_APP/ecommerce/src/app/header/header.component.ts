import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() totalCart = 0;//total cart is coming from parent checkout component
  constructor() { }

  ngOnInit(): void {
  }

}
