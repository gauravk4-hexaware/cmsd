import { Component, OnInit } from '@angular/core';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { VendorService} from 'src/app/Vendor.service';

@Component({
  selector: 'app-vendororderhistory',
  templateUrl: './vendororderhistory.component.html',
  styleUrls: ['./vendororderhistory.component.css']
})
export class VendororderhistoryComponent implements OnInit ,OnDestroy{ 
  vendorService:VendorService;
  private orderhistory;

  constructor(vendorService:VendorService ) {
    this.vendorService = vendorService;
   }

  ngOnInit() {
    let venId = localStorage.getItem('venId');
    this.vendorService.getorderhistory(venId)
    .subscribe(response=> {
        this.orderhistory =response;
        console.log(this.orderhistory)
    });
  }
  ngOnDestroy(){
    console.log('Called before destroying the component...');
  }
  p: number=1;

}
