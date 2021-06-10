import {Component, OnDestroy, OnInit} from '@angular/core';
import {Form, FormBuilder, FormGroup} from "@angular/forms";
import {Observable, Subject, Subscription} from "rxjs";
import {NewsService} from "../../services/news.service";
import {NewFormService} from "../news-form.service";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-news-form-step3',
  templateUrl: './news-form-step3.component.html',
  styleUrls: ['./news-form-step3.component.css']
})
export class NewsFormStep3Component implements OnInit, OnDestroy {

  subscription: Subscription;

  subscriptionForTitre: Subscription;

  form = this.fb.group({


  });

  titre: string;

  form1;

  form2;

  constructor(private fb: FormBuilder, private newFormService: NewFormService, private newsService: NewsService, private sanitizer: DomSanitizer) {

    this.subscriptionForTitre = this.newFormService.getTitre().subscribe(val => {
      this.titre = val;
      console.log("le titre : " + this.titre);
    });
  }



  ngOnInit(): void {

    const draft = localStorage.getItem("STEP_2");

    if (draft) {
      console.log(JSON.parse(draft));
    }

    this.subscriptionForTitre = this.newFormService.getTitre().subscribe(val => {
      this.titre = val;
      console.log("le titre : " + val.value);
    });
  }

  ngOnDestroy(): void {
  }
}
