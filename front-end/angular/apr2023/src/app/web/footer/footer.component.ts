import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/common.service';

@Component({
  selector: 'web-app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  contactForm={"name":"","email":"","mobile":"","message":""};

  constructor(private common:CommonService) { }

  ngOnInit(): void {
  }

}
