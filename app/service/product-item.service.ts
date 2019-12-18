import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ProductItemService {
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    }) 
  };
  baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient,private authenticationService:AuthenticationService) { 

  }
  getAllProducts(){
    let token = "Bearer "+ this.authenticationService.getToken();
    const httpOptions = {
      headers :new HttpHeaders({
        'Content-Type':'application/json',
        'Authorization':token
      })
    };
   // return this.httpClient.get(this.baseUrl+"/menu-items",httpOptions);
   console.log("all product service");
    return this.httpClient.get(this.baseUrl+"/product-service/smartmart/products",httpOptions);
  }

  addProduct(product: any){
    console.log("service"+product);
    var dateParts = product.addDate.split("/");
    var addDateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    var dateParts =product.dateOfManufacture.split("/");
    var dateOfManufactureObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    var dateParts =product.dateOfExpiry.split("/");
    var dateOfExpiryObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    let token = "Bearer "+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body = {
      id:product.id,
      name: product.name,
      type: product.type,
      brand: product.brand,
      quantityType: product.quantityType,
      ratePerQuantity: product.ratePerQuantity,
      stockCount: product.stockCount,
      addDate: addDateObject,
      aisle: product.aisle,
      shelf: product.shelf,
      dateOfManufacture: dateOfManufactureObject,
      dateOfExpiry: dateOfExpiryObject,
      image: product.image
    };
    console.log("body"+body);
    return this.httpClient.post(this.baseUrl+"/product-service/smartmart/addproduct",body,httpOptions);
  }

  getProduct(id) {
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>(this.baseUrl+"/product-service/smartmart/products/"+id, httpOptions);
  }
  editProduct(product){
    var dateParts =product.addDate.split("/");
    var addDateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    var dateParts =product.dateOfManufacture.split("/");
    var dateOfManufactureObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    var dateParts =product.dateOfExpiry.split("/");
    var dateOfExpiryObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body = {
      id: product.id,
      name: product.name,
      type: product.type,
      brand: product.brand,
      quantityType: product.quantityType,
      ratePerQuantity: product.ratePerQuantity,
      stockCount: product.stockCount,
      addDate: addDateObject,
      aisle: product.aisle,
      shelf: product.shelf,
      dateOfManufacture: dateOfManufactureObject,
      dateOfExpiry: dateOfExpiryObject,
      image: product.image
    };
    return this.httpClient.put(this.baseUrl+"/product-service/smartmart/updateproduct", body, httpOptions);
  }

  deleteProductItem(id:any){
    console.log(id);
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.delete(this.baseUrl+"/product-service/smartmart/delete/"+id,httpOptions);
  }
  getProductByPopularity(){
    let token = "Bearer "+ this.authenticationService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+"/product-service/smartmart/product-list/sort-by-popularity", httpOption);
  }
}
