import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { user } from '../user';
@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit {
  registerationForm: FormGroup;
  newUserFlag:boolean = false;
  status: string;
  constructor(private userService: UserService,private router: Router) { }

  ngOnInit() {
    this.registerationForm = new FormGroup({
      'firstName': new FormControl(null, [
        Validators.required
      ]),
      'lastName': new FormControl(null, [
        Validators.required
      ]),
      'age': new FormControl(null, [
        Validators.required
      ]),
      'gender': new FormControl(null, [
        Validators.required
      ]),
      'contactNumber': new FormControl(null, [
        Validators.required,
         Validators.minLength(10),
        Validators.maxLength(10)
      ]),
      'userId': new FormControl(null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(20)
      ]),
      'userType': new FormControl(null, [
        Validators.required
      ]),
      'password': new FormControl(null, [
        Validators.required
      ]),
      'confirmPassword': new FormControl(null, [
        Validators.required
      ]),
      'question1': new FormControl(null, [
        Validators.required
      ]),
      'answer1': new FormControl(null, [
        Validators.required
      ]),
      'question2': new FormControl(null, [
        Validators.required
      ]),
      'answer2': new FormControl(null, [
        Validators.required
      ]),
      'question3': new FormControl(null, [
        Validators.required
      ]),
      'answer3': new FormControl(null, [
        Validators.required
      ]),
    });
  }
  newUser:any;
  register() {
    // this.newUser=this.registerationForm.value;
    
    if(this.registerationForm.value.userType=="U"){
      status="A"
     }else{
     status="P"
    }

    this.newUser ={
      firstName:this.registerationForm.value.firstName,
      lastName:this.registerationForm.value.lastName,
      age:this.registerationForm.value.age,
      gender:this.registerationForm.value.gender,
      contactNumber:this.registerationForm.value.contactNumber,
       userId:this.registerationForm.value.userId,
       password:this.registerationForm.value.password,
      userType:this.registerationForm.value.userType,
      userRewardPoints:0,
      status: status,
      question1:this.registerationForm.value.question1,
    answer1:this.registerationForm.value.answer1,
    question2:this.registerationForm.value.question2,
   answer2:this.registerationForm.value.answer2,
    question3:this.registerationForm.value.question3,
    answer3:this.registerationForm.value.answer3
    }
    console.log( this.newUser);
   
    this.userService.addUser(this.newUser).subscribe((response)=>{
      this.newUserFlag = true;
      console.log( this.newUserFlag);
      // if(response==true){
      //   //this.router.navigate(['login']);
      // } 
    },(error)=>{
      this.newUserFlag = false;
    });
  }
  passwordFlag: boolean;
  passwordMatch() {
    if (this.registerationForm.value.password == this.registerationForm.value.confirmPassword) {
      this.passwordFlag = true;
    } else {
      this.passwordFlag = false;
    }
  }
}
