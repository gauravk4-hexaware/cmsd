import { Component, OnInit } from '@angular/core';
import { VendorService} from 'src/app/vendor.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {

      vendorService:VendorService;
      private vendor;
  
      constructor(vendorService:VendorService ) {
          this.vendorService = vendorService;
      }

      ngOnInit() {
          let venId = localStorage.getItem('venId');
          this.vendorService.getVendor(venId)
          .subscribe(response=> {
              this.vendor =response[0];
              console.log(this.vendor)
              let name = this.vendor.venName;
              localStorage.setItem('name', name);
           });
  }

  }

