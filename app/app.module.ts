import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterationComponent } from './registeration/registeration.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SmartShopViewComponent } from './smart-shop-view/smart-shop-view.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { SmartMartMainComponent } from './smart-mart-main/smart-mart-main.component';
import { ProductSearchComponent } from './product-search/product-search.component';
import { ProductItemComponent } from './product-item/product-item.component';
import { PendingRequestsComponent } from './pending-requests/pending-requests.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { DatePipe } from '@angular/common';
import { BillComponent } from './bill/bill.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OfferAddComponent } from './offer-add/offer-add.component';
import { OfferInfoComponent } from './offer-info/offer-info.component';
import { OfferUpdateComponent } from './offer-update/offer-update.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterationComponent,
    HeaderComponent,
    FooterComponent,
    SmartShopViewComponent,
    LoginComponent,
    SmartMartMainComponent,
    ProductSearchComponent,
    ProductItemComponent,
    PendingRequestsComponent,
    AddProductComponent,
    UpdateProductComponent,
    BillComponent,
    PurchaseHistoryComponent,
    ForgotPasswordComponent,
    OfferAddComponent,
    OfferInfoComponent,
    OfferUpdateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
