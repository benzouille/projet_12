import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NewsService} from "../services/news.service";

@Component({
  selector: 'upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {
  fileName:string = '';

  fileUploadError = false;

  fileUploadSuccess = false;

  disabled: boolean = false;

  uploadProgress:number;



  constructor(private http: HttpClient, private newsService: NewsService) { }

  ngOnInit(): void {
  }

  onTouched = () => {};

  onClick(fileUpload: HTMLInputElement) {
    this.onTouched();
    fileUpload.click();
  }

  onFileSelected(event) {

    console.log('onFileSelected : ' + event.target.files[0].name);

    const file:File = event.target.files[0];

    this.newsService.uploadFile(file);

  }

}
