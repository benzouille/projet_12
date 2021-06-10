import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  h1: string = 'Bienvenue sur le site de l\'APE\n';

  presentation: string = 'L\'APE est une association de parents d\'élèves bénévoles qui s\'investit pour les enfants du regroupement scolaire de la Magnascole et des Crayons Magiques de Koenigsmacker. Ce regroupement englobe les communes d\'Oudrenne, Hunting, Malling, Kerling et Koenigsmacker.\n' +
    'L\'APE organise de nombreuses manifestations afin de récolter des fonds destinés à soutenir les activités des enfants, et cela dans un but non lucratif.';

  constructor() { }

  ngOnInit(): void {
  }

}
