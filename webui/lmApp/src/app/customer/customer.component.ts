import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Customer } from '../model/Customer';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit, OnDestroy{
  
  private customerService:CustomerService;
  private customer;
  
   constructor(customerService: CustomerService ) {
    this.customerService = customerService;
    //window.onload = function () {window.location.reload()}
   }
   ngOnInit() {
    let cusId = localStorage.getItem('cusId');
     this.customerService.getAllCustomers(cusId)
     .subscribe(response=> {
      this.customer = response[0];
      console.log(this.customer);
      let name = this.customer.cusName;
      localStorage.setItem('name', name);
      let ename = this.customer.cusEmail;
      localStorage.setItem('ename', ename);
      let phoneNo = this.customer.cusPhoneNo;
      localStorage.setItem('phoneNo', phoneNo);
      let userName = this.customer.cusUserName;
      localStorage.setItem('userName',userName);

     });
     
}

  ngOnDestroy() {
    console.log('Called before destroying the component....');
  }

}