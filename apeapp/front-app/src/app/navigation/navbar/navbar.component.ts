import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {KeycloakSecurityService} from '../../keycloak/services/keycloak-security.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Output()
  public sidenavToggle = new EventEmitter();

  constructor(public securityService: KeycloakSecurityService) { }

  ngOnInit(): void {
  }


  onToggleSidenav = () => {
    this.sidenavToggle.emit();
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
