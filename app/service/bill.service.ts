import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BillService {
  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }
  baseUrl = environment.baseUrl;
  generateBill(bill:any){
    console.log(bill);
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    // console.log(bill);
    return this.httpClient.post(this.baseUrl+"/product-service/smartmart/bills", bill, httpOptions);

  }
  getBill(id){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get<any>(this.baseUrl+"/product-service/smartmart/bills/"+id, httpOptions);
  }
}