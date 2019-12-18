import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { user } from '../user';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  user: user;
  forgotId: boolean = false;
  forgotPassword: boolean = false;
  invalidContactNumber: boolean = false;
  invalidUserID: boolean = false;
  answersMatched: boolean = false;
  passwordUpdated: boolean = false;
  wrongAnswers: boolean = false;
  gotUserId: boolean = false;
  gotQuestions: boolean = false;
  forgotIdForm : FormGroup;
  forgotPasswordForm : FormGroup;
  setPasswordForm: FormGroup;
  constructor(private router: ActivatedRoute, private navigationRouter: Router, private userService: UserService) { }

  ngOnInit() {
    this.forgotPasswordForm = new FormGroup({
      'userID': new FormControl("", [Validators.required, Validators.maxLength(15)]),
      'answer1': new FormControl("", [Validators.required, Validators.maxLength(50)]),
      'answer2': new FormControl("", [Validators.required, Validators.maxLength(50)]),
      'answer3': new FormControl("", [Validators.required, Validators.maxLength(50)]),
    });
    this.forgotIdForm = new FormGroup({
      'contactNumber': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")])
    });
    this.setPasswordForm = new FormGroup({
      'password': new FormControl("", [Validators.required, Validators.maxLength(15)])
    });
    this.router.paramMap.subscribe(params => {
      if(params.get('forgot') == 'id'){
        this.forgotId = true;
        this.forgotPassword = false;
      }else{
        this.forgotId = false;
        this.forgotPassword = true;
      }
    });
  }

  getDetailsByContactNumber(){
    this.userService.getUserByContactNumber(this.forgotIdForm.value.contactNumber).subscribe((response)=>{
      this.invalidContactNumber = false;
      this.user = response;
      this.gotUserId = true;
    },
    ()=>{
      this.invalidContactNumber = true;
      this.gotUserId = false;
    });
  }

  getDetailsByUserID(){
    this.userService.getUserByUserID(this.forgotPasswordForm.value.userID).subscribe((response)=>{
      
      this.user = response;
      console.log(this.user);
      if(this.user != null){
        this.invalidUserID = false;
        this.gotQuestions = true;
      }else{
        console.log('user id thappu');
        this.invalidUserID = true;
        this.gotQuestions = false;
      }
      
    });
  }

  verifyAnswers(){
    if(this.forgotPasswordForm.value.answer1 == this.user.answer1 && this.forgotPasswordForm.value.answer2 == this.user.answer2 && this.forgotPasswordForm.value.answer3 == this.user.answer3){
      console.log('answers matched');
      this.wrongAnswers = false;
      this.answersMatched = true;
      this.forgotPassword = false;
    }else{
      console.log('thappu');
      this.wrongAnswers = true;
      this.answersMatched = false;
      this.forgotPassword = true;
    }
  }

  setPassword(){
    this.user.password = this.setPasswordForm.value.password;
    this.userService.updateUserWithNewPassword(this.user).subscribe(()=>{
      this.passwordUpdated = true;
    });
  }

  goToLogin() {
    this.navigationRouter.navigate(['login']);
  }

}
