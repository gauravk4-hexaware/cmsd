import { Component, OnInit } from '@angular/core';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { CustomerService } from 'src/app/Customer.service';

@Component({
  selector: 'app-customerorderhistory',
  templateUrl: './customerorderhistory.component.html',
  styleUrls: ['./customerorderhistory.component.css']
})
export class CustomerorderhistoryComponent implements OnInit {
  private details;
  private errorMessage;
  private count:number;
  CustomerService:CustomerService;
  constructor(CustomerService: CustomerService) { 
    this.CustomerService = CustomerService;
    
  }

  ngOnInit() {
    let cusId = localStorage.getItem('cusId');
    this.CustomerService.getStatus(cusId)
    .subscribe(response=> {
        this.details =response;
        console.log("details");
        console.log(this.details);
    }, (error)=>{
      this. errorMessage = "INVALID LOGIN CREDENTIALS"
    });
  }

p: number=1;
}
