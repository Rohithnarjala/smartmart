import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';
import { Offer } from '../offer-add/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    }) 
  };
  baseUrl = environment.baseUrl;
  constructor( private httpClient : HttpClient,
    private authenticateService: AuthenticationService) { }

  addOffer(offer){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.post<any[]>(this.baseUrl+'/product-service/smartmart/offer/'+offer.product ,offer ,  httpOption);
  }

  updateOffer(offer: Offer,id){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.put<any[]>(this.baseUrl+'/product-service/smartmart/offer/'+id ,offer ,  httpOption);
  }

  deleteOffer(id){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.delete(this.baseUrl+'/product-service/smartmart/offer/'+id ,  httpOption);
  }

  getOfferByDate(date){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any[]>(this.baseUrl+'/product-service/smartmart/offer-list/'+date , httpOption);
  }

  getOfferById(id){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/product-service/smartmart/offer/'+id , httpOption);
  }

  getCurrentOffer(){
    let token = "Bearer "+ this.authenticateService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/product-service/smartmart/offer', httpOption);
  }
}

