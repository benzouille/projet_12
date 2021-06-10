import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {KeycloakSecurityService} from '../../keycloak/services/keycloak-security.service';

@Component({
  selector: 'app-sidenav-list',
  templateUrl: './sidenav-list.component.html',
  styleUrls: ['./sidenav-list.component.css']
})
export class SidenavListComponent implements OnInit {

  @Output()
  private sidenavClose = new EventEmitter();

  constructor(public securityService: KeycloakSecurityService) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  public onSidenavClose() {
    this.sidenavClose.emit();
  }

  onLogout() {
    this.securityService.kc.logout();
  }

  onProfile() {
    this.securityService.kc.accountManagement();
  }

  onLogin() {
    this.securityService.kc.login();
  }

  onRegister() {
    this.securityService.kc.register();
  }
}
