import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { AuthService } from '../auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginError: boolean = false;
  
  constructor(private authenticationService:AuthenticationService,private authService: AuthService,private router:Router) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'userName': new FormControl(null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(20)
      ]),
      'password': new FormControl(null, [
        Validators.required
      ])
    });
  }
  error:any;
  userFlag :boolean =false;
  denyFlag:boolean =false;
  login(loginForm){
    console.log(this.loginForm.value);
  this.authenticationService.authenticate(loginForm.value.userName,loginForm.value.password)
  .subscribe((response) =>{
    console.log(this.loginForm.value);
    console.log(response);
    this.authenticationService.setToken(response.token);
    this.authenticationService.setFirstName(response.firstName);
     this.authenticationService.setStatus(response.status);
    this.authenticationService.setUserName(response.userName);
    this.authenticationService.setUserType(response.userType);
    this.authService.login(loginForm.value.userName);
   if(response.status=='A'){
    this.router.navigate(["/smartmartmain",loginForm.value.userName]);
   }else if(response.status=='P'){
     this.userFlag = true;
   }else if(response.status=='D'){
     this.denyFlag = true;
   }

  },(error)=>{
    this.error = "invalid userName/password";
    console.log(this.error);
    this.loginError = true;
  });
}
goToForgotUserID(){
  this.router.navigate(['forgot-password','id']);
}

goToForgotPassword(){
  this.router.navigate(['forgot-password','password']);
}
}
