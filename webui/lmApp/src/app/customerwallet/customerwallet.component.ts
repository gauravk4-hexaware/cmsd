import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-customerwallet',
  templateUrl: './customerwallet.component.html',
  styleUrls: ['./customerwallet.component.css']
})
export class CustomerwalletComponent implements OnInit, OnDestroy {
  private CustomerService:CustomerService;
  private CustomerWalletComponent;
   constructor(CustomerService: CustomerService ) {
    this.CustomerService = CustomerService;
   }
   ngOnInit() {
    let cusId = localStorage.getItem('cusId');
    this.CustomerService.getCustomersWallet(cusId)
    .subscribe(response=> {
      this.CustomerWalletComponent = response;
      console.log(this.CustomerWalletComponent);
    })
  }
  ngOnDestroy(){
    console.log('Called before destroying the component...');
  }
}
