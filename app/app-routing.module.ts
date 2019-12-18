import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterationComponent } from './registeration/registeration.component';
import { SmartShopViewComponent } from './smart-shop-view/smart-shop-view.component';
import { LoginComponent } from './login/login.component';
import { SmartMartMainComponent } from './smart-mart-main/smart-mart-main.component';
import { PendingRequestsComponent } from './pending-requests/pending-requests.component';
import { AuthGuard } from './auth.guard';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { BillComponent } from './bill/bill.component';
import { PurchaseHistoryComponent } from './purchase-history/purchase-history.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { OfferAddComponent } from './offer-add/offer-add.component';
import { OfferUpdateComponent } from './offer-update/offer-update.component';
import { OfferInfoComponent } from './offer-info/offer-info.component';


const routes: Routes = [
  { path: "",component:SmartShopViewComponent},
  { path: 'registeration',component:RegisterationComponent},
  { path: 'smartshopview',component:SmartShopViewComponent,canActivate: [AuthGuard]},
  { path: 'login',component:LoginComponent},
  { path: 'smartmartmain',component:SmartMartMainComponent,canActivate: [AuthGuard]},
  { path: 'smartmartmain/:user',component:SmartMartMainComponent,canActivate: [AuthGuard]},
  { path: 'pendingrequest',component:PendingRequestsComponent,canActivate: [AuthGuard]},
  { path: 'addProduct',component:AddProductComponent,canActivate: [AuthGuard]},
  { path: 'updateProduct',component:UpdateProductComponent,canActivate: [AuthGuard]},
  { path: 'updateProduct/:id',component:UpdateProductComponent,canActivate: [AuthGuard]},
  { path: 'bill',component:BillComponent,canActivate: [AuthGuard]},
  { path: 'purchasehistory',component:PurchaseHistoryComponent,canActivate: [AuthGuard]},
  { path: 'forgot-password',component:ForgotPasswordComponent},
  { path: 'forgot-password/:forgot',component:ForgotPasswordComponent},
  {path:'offer-add', component: OfferAddComponent, canActivate: [AuthGuard]},
  {path:'offer-update', component: OfferUpdateComponent, canActivate: [AuthGuard]},
  {path:'offer-info/:id', component: OfferInfoComponent, canActivate: [AuthGuard]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
