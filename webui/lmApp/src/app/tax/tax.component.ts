import { Component, OnInit } from '@angular/core';
import { VendorService} from 'src/app/Vendor.service';
@Component({
  selector: 'app-tax',
  templateUrl: './tax.component.html',
  styleUrls: ['./tax.component.css']
})
export class TaxComponent implements OnInit {
  vendorService:VendorService;
  private tax;
  constructor(vendorService:VendorService) {
    this.vendorService = vendorService;
    
   }

  ngOnInit() {

  }
  update(month) {
    console.log(month)
    let venId = localStorage.getItem('venId');
    this.vendorService.getTaxDetails(venId, month)
    .subscribe(response=> {
      this.tax =response;
      console.log(this.tax);
  })
}
}

