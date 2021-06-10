import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {AssoBureauComponent} from './asso-bureau/asso-bureau.component';
import {PageNotFoundComponent} from "./navigation/page-not-found/page-not-found.component";
import {MainPageComponent} from "./navigation/main-page/main-page.component";

const routes: Routes = [
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: '', component: AppComponent },
  { path: 'accueil', component: MainPageComponent},
  { path: 'asso-bureau', component: AssoBureauComponent},

  {
    path: 'news',
    loadChildren: () => import('./news/news.module').then(m => m.NewsModule)
  },
  {
    path: "**",
    component: PageNotFoundComponent
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
