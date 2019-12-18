import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  @Output() changeProductList: any;
  @Output() sortEmitter: any;
  searchString: String;
  sortType:String;
  userType: String;
  constructor(private authenticateService: AuthenticationService) {
    this.changeProductList = new EventEmitter();
    this.sortEmitter=new EventEmitter();
   }

  ngOnInit() {
    this.userType = this.authenticateService.getUserType();
  }
  filterProduct() {
    this.changeProductList.emit(this.searchString);
  }
  sort(){
    this.sortEmitter.emit(this.sortType);
  }
  
}
