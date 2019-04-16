import { Injectable } from 'node_modules/@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Menu } from './model/Menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private http:HttpClient;
  constructor(http:HttpClient) {
    this.http = http;
  }

  getAllMenu(): Observable<Menu[]>{
    return this.http.get<Menu[]>('http://localhost:8080/FTP112/api/Menu/');
   
  }
  fetchVendors(selectedFoodId): Observable<Menu[]>{
    console.log(selectedFoodId);
   return this.http.get<Menu[]>('http://localhost:8080/FTP112/api/customer/venName/'+selectedFoodId);
  }
  fetchMenuAdd(): Observable<Menu[]>{
    return this.http.get<Menu[]>('http://localhost:8080/FTP112/api/Menu/show/');
  }
  insertMenu(venId, foodId, price): Observable<any>{
    return this.http.post('http://localhost:8080/FTP112/api/Menu/'+venId+'/update/'+foodId+'/'+price+'/',{});
  }
  deleteVenMen(venId, foodId): Observable<any>{
    return this.http.delete('http://localhost:8080/FTP112/api/Menu/'+venId+'/update/'+foodId+'/');
  }
}
