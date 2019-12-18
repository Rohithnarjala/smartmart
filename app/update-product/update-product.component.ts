import { Component, OnInit } from '@angular/core';
import { ProductItemService } from '../service/product-item.service';
 import { DatePipe } from '@angular/common';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  editProductForm: FormGroup;
  product: any;
  addDate:string;
  dateOfManufacture: string;
  dateOfExpiry: string;
  constructor(private router: ActivatedRoute,private productService: ProductItemService , private datePipe: DatePipe, private route: Router) {
    this.editProductForm = new FormGroup({
      'id': new FormControl("", [Validators.required]),
      'name': new FormControl("", [Validators.required,Validators.minLength(2),
        Validators.maxLength(20)]),
      'type': new FormControl("", [Validators.required]),
      'brand': new FormControl("", [Validators.required]),
      'quantityType': new FormControl("", [Validators.required]),
      'ratePerQuantity': new FormControl("", [Validators.required,Validators.pattern('[0-9]+')]),
      'stockCount': new FormControl("", [Validators.required]),
      'addDate': new FormControl("", [Validators.required,  Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
      'aisle': new FormControl("", [Validators.required]),
      'shelf': new FormControl("", [Validators.required]),
      'dateOfManufacture': new FormControl("", [Validators.required,  Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
      'dateOfExpiry': new FormControl("", [Validators.required,  Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
      'image': new FormControl("", [Validators.required])
    });
   }

  ngOnInit() {
    this.router.paramMap.subscribe(params => {
      console.log(params);
      this.productService.getProduct(params.get('id')).subscribe((response) => {
        console.log(response);
        this.product = response;
        this.addDate = this.datePipe.transform(this.product.addDate , 'dd/MM/yyyy');
        this.dateOfManufacture = this.datePipe.transform(this.product.dateOfManufacture , 'dd/MM/yyyy');
        this.dateOfExpiry = this.datePipe.transform(this.product.dateOfExpiry , 'dd/MM/yyyy');

        this.editProductForm = new FormGroup({
          'id': new FormControl(this.product.id, [Validators.required]),
          'name': new FormControl(this.product.name, [Validators.required,Validators.minLength(2),
            Validators.maxLength(20)]),
          'type': new FormControl(this.product.type, [Validators.required]),
          'brand': new FormControl(this.product.brand, [Validators.required]),
          'quantityType': new FormControl(this.product.quantityType, [Validators.required]),
          'ratePerQuantity': new FormControl(this.product.ratePerQuantity, [Validators.required,Validators.pattern('[0-9]+')]),
          'stockCount': new FormControl(this.product.stockCount, [Validators.required]),
          'addDate': new FormControl(this.addDate, [Validators.required,  Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
          'aisle': new FormControl(this.product.aisle, [Validators.required]),
          'shelf': new FormControl(this.product.shelf, [Validators.required]),
          'dateOfManufacture': new FormControl(this.dateOfManufacture, [Validators.required, Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
          'dateOfExpiry': new FormControl(this.dateOfExpiry, [Validators.required,  Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
          'image': new FormControl(this.product.image, [Validators.required])
        });
        console.log(this.editProductForm.value);
      });
      });
  }
  onSubmit(editProductForm){
    this.productService.editProduct(editProductForm.value).subscribe((response)=>{
      this.route.navigate(['smartmartmain']);
    })
  }
  }


