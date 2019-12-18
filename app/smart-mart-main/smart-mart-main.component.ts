import { Component, OnInit } from '@angular/core';
import { ProductItemService } from '../service/product-item.service';
import { AuthenticationService } from '../service/authentication.service';
import { product } from '../product-item/product';

@Component({
  selector: 'app-smart-mart-main',
  templateUrl: './smart-mart-main.component.html',
  styleUrls: ['./smart-mart-main.component.css']
})
export class SmartMartMainComponent implements OnInit {
  productList: any;
  filteredProduct: any;
  user: String;
  product:any;

  constructor(private productItemService:ProductItemService,private authenticationService:AuthenticationService) { }

  ngOnInit() {
    this.productItemService.getAllProducts().subscribe(product =>{
      console.log("get product component");
      this.productList = product;
      this.filteredProduct = this.productList;
      this.user = this.authenticationService.getUserName();
    });
  }
  filterList($event) {


    this.filteredProduct = this.productList.filter(
      (item: product) => item.name.toLocaleLowerCase().indexOf($event) != -1
    );
  }
  sort($event){
    if($event == "name"){
      this.filteredProduct =   this.filteredProduct.sort((obj1, obj2) => {
        if (obj1.name > obj2.name) {
            return 1;
        }
        if (obj1.name < obj2.name) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "price"){
      this.filteredProduct =   this.filteredProduct.sort((obj1, obj2) => {
        if (obj1.ratePerQuantity > obj2.ratePerQuantity) {
            return 1;
        }
        if (obj1.ratePerQuantity < obj2.ratePerQuantity) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "stock"){
      this.filteredProduct =   this.filteredProduct.sort((obj1, obj2) => {
        if (obj1.stockCount > obj2.stockCount) {
            return 1;
        }
        if (obj1.stockCount < obj2.stockCount) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "popular"){
      this.productItemService.getProductByPopularity().subscribe(response =>{
        this.filteredProduct = response;
      })
    }
  }
delete($event){
  this.productItemService.deleteProductItem($event).subscribe(response=>{
    this.ngOnInit();

  })
}
}
