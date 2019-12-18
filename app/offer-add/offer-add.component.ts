import { Component, OnInit } from '@angular/core';
import { ProductItemService } from '../service/product-item.service';
import { DatePipe } from '@angular/common';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { product } from '../product-item/product';
import { OfferService } from '../service/offer.service';

@Component({
  selector: 'app-offer-add',
  templateUrl: './offer-add.component.html',
  styleUrls: ['./offer-add.component.css']
})
export class OfferAddComponent implements OnInit {

  addOfferForm: FormGroup;
  productList: any;
  product: any;
  errorMessage: string;
  errorFlag: boolean;

  constructor(private datePipe: DatePipe, private productService: ProductItemService, private offerService: OfferService) { }

  ngOnInit() {
    this.errorFlag = false;
    this.productService.getAllProducts().subscribe(response =>{
      this.productList = response;
    });

    let addDate = this.datePipe.transform(new Date , 'dd/MM/yyyy');
    this.addOfferForm = new FormGroup({
      offerDate: new FormControl(addDate, [Validators.required, Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
      offerPercentage: new FormControl('', [Validators.required]),
      offerDetails: new FormControl('', [Validators.required]),
      product: new FormControl('', [Validators.required]),
    });
  }

  addOffer(addOfferForm){
    var dateParts = addOfferForm.value.offerDate.split("/");
    var addDateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    addOfferForm.value.offerDate = addDateObject;
    console.log(addOfferForm.value);
      this.offerService.addOffer(addOfferForm.value).subscribe(response =>{
      }, error =>{
        this.errorMessage = error.error.message;
        this.errorFlag = true;
      }
      );
  
  }

}
