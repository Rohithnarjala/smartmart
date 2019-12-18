import { Component, OnInit } from '@angular/core';
import { BillService } from '../service/bill.service';
import { AuthenticationService } from '../service/authentication.service';
import { ProductItemService } from '../service/product-item.service';

@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {

  productList: any[];
  detailsFlag: boolean;
  currentBillId: number = 0;
  constructor(private billService: BillService, private authenticateService: AuthenticationService, private productService: ProductItemService) { }

  billDetails: any[];
  ngOnInit() {
    this.billService.getBill(this.authenticateService.getUserName()).subscribe(response => {
      this.billDetails = response;
      console.log(this.billDetails);
      this.billDetails.forEach(resp =>{
        resp.billDetailsList.forEach(resp1 =>{
          this.productService.getProduct(resp1.productId).subscribe(response1 =>{
            resp1['productDetails'] = response1;
          })
        })
      })
    })
  }

  getProductDetails(billDetailsList: any[]){
    this.detailsFlag = true;
    let i = 0;
    this.productList = [];
    billDetailsList.forEach(resp =>{
      this.productList.push(resp.productDetails);
    })
    for(let i=0; i<billDetailsList.length ; i++){
      this.productList[i]['quantity'] = billDetailsList[i].quantity;
    }


  }

}
