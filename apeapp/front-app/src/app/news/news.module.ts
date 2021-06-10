import {ModuleWithProviders, NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewsDetailComponent } from './news-detail/news-detail.component';
import { NewsFormComponent } from './news-form/news-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatRadioModule} from '@angular/material/radio';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {NewsService} from './services/news.service';
import {NewsRoutingModule} from './news-routing.module';
import { NewsFormStep1Component } from './news-form/news-form-step1/news-form-step1.component';
import { NewsFormStep2Component } from './news-form/news-form-step2/news-form-step2.component';
import { NewsFormStep3Component } from './news-form/news-form-step3/news-form-step3.component';
import { UploadFileComponent } from './upload-file/upload-file.component';
import {MatStepperModule} from "@angular/material/stepper";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from '@angular/material/core';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatSelectModule} from "@angular/material/select";
import {MatIconModule} from "@angular/material/icon";
import {FlexModule} from "@angular/flex-layout";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {NewFormService} from "./news-form/news-form.service";


@NgModule({
  declarations: [
    NewsDetailComponent,
    NewsFormComponent,
    NewsFormStep1Component,
    NewsFormStep2Component,
    NewsFormStep3Component,
    UploadFileComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatRadioModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    NewsRoutingModule,
    MatStepperModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatSelectModule,
    MatIconModule,
    FlexModule,
    MatProgressBarModule
  ],
  providers: [
    MatDatepickerModule,
    MatNativeDateModule,
    NewFormService,
    NewsService,
  ],
})
export class NewsModule {
  static forRoot(): ModuleWithProviders<NewsModule> {
    return {
      ngModule: NewsModule,
      providers: [
        NewsService
      ],
    };
  }
}
