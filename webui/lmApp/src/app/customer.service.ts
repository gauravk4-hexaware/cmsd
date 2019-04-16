import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './model/Customer';
import { Wallet } from './model/Wallet';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
 
    private http:HttpClient;
  constructor(http:HttpClient) {
    this.http = http;
  }
  getorderdetails() {
  }
  

  getAllCustomers(cusId):Observable<Customer[]>{
    console.log(cusId);
    return this.http.get<Customer[]>('http://localhost:8080/FTP112/api/customer/'+cusId);
}

  getCustomersWallet(cusId): Observable<Wallet[]>{
    return this.http.get<Wallet[]>('http://localhost:8080/FTP112/api/customer/'+cusId+'/wallet');
   
  }

  authorize(cusId, cusPassword):Observable<any>{
    return this.http.post('http://localhost:8080/FTP112/api/customer/auth',{"cusId":cusId, "cusPassword":cusPassword});
  }
getStatus(cusId): Observable<Customer[]>{
  console.log(cusId);
 return this.http.get<Customer[]>('http://localhost:8080/FTP112/api/customer/'+cusId+'/orders');
}
getWallet(cusId):Observable<Wallet[]>{
  console.log(cusId);
  return this.http.get<Wallet[]>('http://localhost:8080/FTP112/api/customer/'+cusId+'/wallet');
}

placeOrder(cusId, venId, walletId, foodId, quantity, total):Observable<any>{
  return this.http.post('http://localhost:8080/FTP112/api/customer/'+foodId+'/orders/'+quantity,{
    'cusId':cusId,
    'venId':venId,
    'totalOrderPrice':total,
    'walId':walletId
  });
  


}


}
