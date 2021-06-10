import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {AssoBureauComponent} from './asso-bureau/asso-bureau.component';
import {AppRoutingModule} from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NewsCardComponent} from './news/news-card/news-card.component';
import {NavbarComponent} from './navigation/navbar/navbar.component';
import {FooterComponent} from './navigation/footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {MatTabsModule} from '@angular/material/tabs';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { NewsListTabComponent } from './news/news-list-tab/news-list-tab.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import { SidenavListComponent } from './navigation/sidenav-list/sidenav-list.component';
import {CommonModule} from '@angular/common';
import {KeycloakSecurityService} from './keycloak/services/keycloak-security.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatRadioModule} from '@angular/material/radio';
import {PageNotFoundComponent} from "./navigation/page-not-found/page-not-found.component";
import { MainPageComponent } from './navigation/main-page/main-page.component';

// const secService = new KeycloakSecurityService();

@NgModule({
  declarations: [
    AppComponent,
    AssoBureauComponent,
    NewsCardComponent,
    NavbarComponent,
    FooterComponent,
    NewsListTabComponent,
    SidenavListComponent,
    PageNotFoundComponent,
    MainPageComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatTabsModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule,
  ],
  exports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatTabsModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule,
  ],
  providers: [{provide: APP_INITIALIZER, deps: [KeycloakSecurityService], useFactory: kcFactory, multi: true}],
    // providers: [{provide: KeycloakSecurityService, useValue: secService}],
  bootstrap: [AppComponent]
})
export class AppModule {
}

function kcFactory(kcSecurity: KeycloakSecurityService) {
    return () => kcSecurity.init();
}
