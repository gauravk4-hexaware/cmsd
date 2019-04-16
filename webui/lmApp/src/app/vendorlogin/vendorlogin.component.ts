import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-vendorlogin',
  templateUrl: './vendorlogin.component.html',
  styleUrls: ['./vendorlogin.component.css']
})
export class VendorloginComponent implements OnInit {
  private errorMessage;
  VendorService:VendorService;
  constructor(private router: Router,VendorService:VendorService)
  {
    this.VendorService = VendorService;
   }

  ngOnInit() {
  }
 submit(form) {
  console.log(form.value.id);
  console.log(form.value.password);
  if (form.valid ){
    let venId = form.value.id;
    let venPassword = form.value.password;
    this.VendorService.authenticate(venId, venPassword)
    
    .subscribe(response=> {
      window.alert("welcome");
      this.router.navigate(['/vendors',form.value.id,'dashboard']);
    }, (error)=>{
    this.errorMessage = "INVALID LOGIN CREDENTIALS."
  });

 }

}

}
