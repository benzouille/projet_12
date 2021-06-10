import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CommunicationModel} from "../model/CommunicationModel";

@Component({
  selector: 'app-news-detail',
  templateUrl: './news-detail.component.html',
  styleUrls: ['./news-detail.component.css']
})
export class NewsDetailComponent implements OnInit {

  communication: CommunicationModel;


  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.communication = this.route.snapshot.data["communication"];

    console.log("communication : " + this.communication.title);

  }

}
