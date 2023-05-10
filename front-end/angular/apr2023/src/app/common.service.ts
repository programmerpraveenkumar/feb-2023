import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  //common event service
  public eventService = new BehaviorSubject("");
  constructor(private httpclient:HttpClient) { }
  showAlert(message:string){
    alert(message);
  }
  // getBusinessActions(){
    
  //   return [
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"title2","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //     {"title":"Selection of Business","description":"There are many variations of passages of Lorem Ipsum available, but the form, by injected humour, or randomised"},
  //   ];
  // }
  saveContact(params:any){
    return this.httpclient.post("http://localhost:8080/saveContact",params);
  }
}
