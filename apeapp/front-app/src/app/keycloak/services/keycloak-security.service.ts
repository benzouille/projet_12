import { Injectable } from '@angular/core';
import {KeycloakInstance} from 'keycloak-js';
import {HttpClient, HttpHeaders} from '@angular/common/http';

declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public kc;

  constructor() { }

  async init(){
    console.log('Security init');
    this.kc = new Keycloak({
        url: 'http://localhost:8080/auth/',
        realm: 'magnascole',
        clientId: 'front-app',
      });
    await this.kc.init({
      // onLoad: 'login-required'
      onLoad: 'check-sso',
      // promiseType: 'native'
    });
    // TODO A VIRER
    console.log(this.kc.token);
  }
}
