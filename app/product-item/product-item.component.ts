import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { product } from './product';
import { AuthService } from '../auth.service';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { ProductItemService } from '../service/product-item.service';
import { OfferService } from '../service/offer.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  @Input() item: product;
  @Output() addItemEmitter: any;
  @Output() deleteEmitter:any;
  userName: String;
  userType: String;
  status: String;
  firstName: String;
  list: any;
  offerList: any[];
  constructor(private router: Router,private offerService: OfferService , private authService: AuthService,private authenticationService:AuthenticationService,private productService:ProductItemService) {
    this.addItemEmitter = new EventEmitter();
    this.deleteEmitter=new EventEmitter();
    this.userName=this.authenticationService.getUserName();
    this.userType=this.authenticationService.getUserType();
    this.status=this.authenticationService.getStatus();
    this.firstName=this.authenticationService.getFirstName();
    this.productService.getAllProducts().subscribe(response=>{
      this.list=response;
    });
   }

  ngOnInit() {
    this.offerService.getCurrentOffer().subscribe(response => {
      this.offerList = response;
    })    
  }
  getUserType(){
    return this.authenticationService.getUserType();
  }
  getUser(){
    return this.authenticationService.getUserName();
  }
  update(id:any){
    this.router.navigate(['updateProduct',id]);
  }
  delete(id:any){
    // this.productService.deleteProductItem(code).subscribe(response=>{
    //   this.productService.getAllProducts().subscribe(response=>{
    //     this.list=response;
    //     //this.router.navigate(['smartmartmain']);
    //   });
    // });
  this.deleteEmitter.emit(id);
  }
}
