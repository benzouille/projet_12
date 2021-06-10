import { Component, OnInit } from '@angular/core';
import {NgForm, NgModel, FormBuilder, FormControl, FormGroup,  Validators} from '@angular/forms';
import {STEPPER_GLOBAL_OPTIONS} from "@angular/cdk/stepper";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS, useValue: {showError:true}
    }
  ]
})



export class NewsFormComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  submit(step1, step2){

    console.log(step1, step2);

  }
}

