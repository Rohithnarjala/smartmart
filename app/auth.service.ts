import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedin: boolean = false;
  user: string;
  constructor() { }
  currentUser() {
    return this.user;
  }
  login(userLoggedIn) {
    this.user = userLoggedIn;
    this.loggedin = true;
  }
  logout() {
    this.user = null;
    this.loggedin = false;
  }
  isloggedin() {
    return this.loggedin;
  }
}
