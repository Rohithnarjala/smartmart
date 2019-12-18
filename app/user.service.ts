import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { user } from './user';
import { AuthenticationService } from './service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    }) 
  };
  baseUrl = environment.baseUrl;
  registrationForm: user;
  constructor(private httpClient:HttpClient,private authenticationService:AuthenticationService) { }

  addUser(newUser: user) {
    console.log(newUser);
    return this.httpClient.post<any>(this.baseUrl+"/authentication-service/smartmart/users",newUser);
  }
  getAllPendingAdminList(){
    let token = "Bearer "+ this.authenticationService.getToken();
    const httpOptions = {
      headers :new HttpHeaders({
        'Content-Type':'application/json',
        'Authorization':token
      })
    };
   console.log("all pending Admin List service");
    return this.httpClient.get(this.baseUrl+"/product-service/smartmart/admins",httpOptions);
  }
  approvedRequests(adminList: any) {
    let token = "Bearer "+ this.authenticationService.getToken();
    const httpOptions = {
      headers :new HttpHeaders({
        'Content-Type':'application/json',
        'Authorization':token
      })
    };
    //return this.httpClient.put(this.baseUrl+"/menu-items/",item,httpOptions);
    return this.httpClient.put(this.baseUrl+"/product-service/smartmart/admins",adminList,httpOptions);
  }
  getUserList(){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get<any>(this.baseUrl + "/product-service/smartmart/user", httpOptions);
  }
  getUserByContactNumber(contactNumber){
    return this.httpClient.get<any>(this.baseUrl+"/product-service/smartmart/users/contact-number/"+contactNumber);
  }

  getUserByUserID(userID){
    return this.httpClient.get<any>(this.baseUrl+"/product-service/smartmart/users/user-id/"+userID);
  }
  updateUserWithNewPassword(user){
    return this.httpClient.put<any>(this.baseUrl+"/product-service/smartmart/users/new-password",user);
  }
}
