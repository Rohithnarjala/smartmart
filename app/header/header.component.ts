import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService,private authenticationService:AuthenticationService) { }

  ngOnInit() {
  }
  logout() {
    this.authenticationService.setToken(null);
    this.authenticationService.setUserType(null);
    this.authenticationService.setUserName(null);
    this.authenticationService.setStatus(null);
    this.authenticationService.setFirstName(null);
    this.authService.logout();
  }
  getUser() {
    return this.authenticationService.getUserName();
  }
  getUserType(){
    return this.authenticationService.getUserType();
  }
  getSuperAdmin(){
    console.log(this.authenticationService.getUserType());
    return this.authenticationService.getUserType();
  }
  getStatus(){
    return this.authenticationService.getStatus();
  }
}
