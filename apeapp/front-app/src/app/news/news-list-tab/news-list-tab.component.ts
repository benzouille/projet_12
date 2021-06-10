import {Component, OnInit} from '@angular/core';
import {NewsService} from '../services/news.service';
import {noop, Observable} from "rxjs";
import {CommunicationModel} from "../model/CommunicationModel";
import {filter, map, shareReplay, tap} from "rxjs/operators";


@Component({
  selector: 'app-news-list-tab',
  templateUrl: './news-list-tab.component.html',
  styleUrls: ['./news-list-tab.component.css']
})
export class NewsListTabComponent implements OnInit {

  public news: any;
  public errorMessage: any;

  allComs: CommunicationModel[];

  allComs$: Observable<CommunicationModel[]>;
  manifComs$: Observable<CommunicationModel[]>;
  actuComs$: Observable<CommunicationModel[]>;
  infoComs$: Observable<CommunicationModel[]>;

  constructor(private newsService: NewsService) {
  }

  ngOnInit(): void {
    this.newsService.getNewsCommunicationsForSite()
      .subscribe(data => {
          this.news = data;
        }
        , err => {
          this.errorMessage = err.error.message;
        });

    const communications$ = this.newsService.getNewsCommunicationsForSite();

    const allCommunications$ = communications$.pipe(
      tap(() => console.log('const allCommunications$')),
      map(res => Object.values(res)),
      shareReplay()
    );

    this.allComs$ = allCommunications$
      .pipe(
        map(comms => comms)
      );

    this.manifComs$ = allCommunications$
      .pipe(
        map(comms => comms.filter(comm => comm.typeCom == 'MANIFESTATION'))
      );

    this.actuComs$ = allCommunications$
      .pipe(
        map(comms => comms.filter(comm => comm.typeCom == 'ACTUALITE'))
      );

    this.infoComs$ = allCommunications$
      .pipe(
        map(comms => comms.filter(comm => comm.typeCom == 'INFORMATION'))
      );

  }

  imageToShow: any;

  private createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
      this.imageToShow = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

  public getImageFromService(titleImage: string) {
    // this.isImageLoading = true;
    this.newsService.getImageFile(titleImage).subscribe(data => {
      this.createImageFromBlob(data);
      // this.isImageLoading = false;
    }, error => {
      // this.isImageLoading = false;
      console.log(error);
    });
  }
}
