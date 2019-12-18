import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { user } from '../user';

@Component({
  selector: 'app-pending-requests',
  templateUrl: './pending-requests.component.html',
  styleUrls: ['./pending-requests.component.css']
})
export class PendingRequestsComponent implements OnInit {
  pendingAdminList: any;

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userService.getAllPendingAdminList().subscribe(response =>{
      if(response!=null){
        this.pendingAdminList=response;
        console.log("pending"+this.pendingAdminList);
      }
    console.log(this.pendingAdminList);
    });

  }
  approve(adminList:user){
    console.log(adminList);
    adminList.status = "A";
    this.userService.approvedRequests(adminList).subscribe(response =>{
      this.userService.getAllPendingAdminList().subscribe(response =>{
        if(response!=null){
          this.pendingAdminList=response;
        }else if(response == null){
          console.log("else"+this.pendingAdminList);
          this.pendingAdminList =null;
         
        }
        
        });
    });
  }
  deny(adminList:user){
    console.log(adminList);
    adminList.status = "D";
    this.userService.approvedRequests(adminList).subscribe(response =>{
      this.userService.getAllPendingAdminList().subscribe(response =>{
        if(response!=null){
          this.pendingAdminList=response;
        }else if(response == null){
          console.log("else"+this.pendingAdminList);
          this.pendingAdminList =null;
         
        }
        
        });
    });
  }
}
