import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  //common event service
  public eventService = new BehaviorSubject("");
  constructor() { }
  showAlert(message:string){
    alert(message);
  }
}
