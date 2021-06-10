import { Component, OnInit } from '@angular/core';
import {Office} from './Office';

@Component({
  selector: 'app-asso-bureau',
  templateUrl: './asso-bureau.component.html',
  styleUrls: ['./asso-bureau.component.css']
})
export class AssoBureauComponent implements OnInit {

  office = Office;
  description: any;

  constructor() { }

  ngOnInit(): void {
    this.description = 'Le nouveau Comité, élu le lors de l\'AG du 29 novembre 2019, se compose de 7 personnes au Office, ainsi que de nombreux assesseurs.';
  }

}
