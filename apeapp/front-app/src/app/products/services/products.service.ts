import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }
  //constructor(private http: HttpClient, private securityService: KeycloakSecurityService) { }

  public getCotisation(){
    return this.http.get('http://localhost:9101/communicationsTest');
  }
}
