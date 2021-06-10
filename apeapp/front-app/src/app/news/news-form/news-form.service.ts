import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import {AbstractControl, Form} from "@angular/forms";

@Injectable()
export class NewFormService {



  private subject = new Subject<any>();

  sendTitre(titre: AbstractControl){
    this.subject.next({val : titre.value});
  }

  getTitre():Observable<any>{
    console.log("le titre : " + this.subject.next());
    return this.subject.asObservable();

  }

}
