import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit , OnDestroy {
  private customerService:CustomerService;
  constructor(private router: Router, customerService: CustomerService)
  {
    this.customerService = customerService;
  }
  errorMessage:string;
  ngOnInit() {
  }
  submit(form) {
    console.log(form.value.id);
    console.log(form.value.password);
    if (form.valid ){
     let cusId = form.value.id;
     localStorage.setItem("cusId",cusId);
     let cusPassword = form.value.password;
     this.customerService.authorize(cusId, cusPassword)
     .subscribe(response=> {
      window.alert("welcome");
     this.router.navigate(['/customers',cusId,'dashboard']);
     }, (error)=>{
    this.errorMessage = "Invalid Login credentials."
    });

  }
 
}
ngOnDestroy(){
  console.log('Called before destroying the customer logIn...');
}
}