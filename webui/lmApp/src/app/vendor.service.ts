import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vendor } from './model/Vendor';
import { Menu } from './model/Menu';
@Injectable({
  providedIn: 'root'
})
export class VendorService {

 private http:HttpClient;
  constructor(http:HttpClient) {
    this.http = http;

   }

   getVendor(venId): Observable<Vendor[]>{
     console.log(venId);
    return this.http.get<Vendor[]>('http://localhost:8080/FTP112/api/vendors/'+venId);
  }

  getorderhistory(venId): Observable<Vendor[]>{
    console.log(venId);
   return this.http.get<Vendor[]>('http://localhost:8080/FTP112/api/vendors/'+venId+'/orders');
 }
 authenticate(venId, venPassword):Observable<any>{
  console.log(venId);
  console.log(venPassword);
  return this.http.post('http://localhost:8080/FTP112/api/vendors/Auth',{"venId":venId, "venPassword":venPassword})
}
getPendingOrders(venId): Observable<Menu[]>{
  console.log(venId);
 return this.http.get<Menu[]>('http://localhost:8080/FTP112/api/vendors/'+venId+'/pending');
}
updateOrder(venId, st, orderId, itemId, str):Observable<any> {
  console.log("came in service");
  console.log(venId);
  console.log("Selected orderId: ", orderId);
  console.log("Selected itemid: ", itemId);
  console.log("status:"+st);
  console.log("Comment:"+str);
  return this.http.put<any>('http://localhost:8080/FTP112/api/vendors/'+venId+'/orders/'+itemId, {"orderStatus":st, "orderId":orderId, "orderComments":str});
}

getTaxDetails(venId, month): Observable<Menu[]>{
  console.log(venId);
  console.log(month);
 return this.http.get<Menu[]>('http://localhost:8080/FTP112/api/vendors/'+venId+'/tax/'+month);
}
}
