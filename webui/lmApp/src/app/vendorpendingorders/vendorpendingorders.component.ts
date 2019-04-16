import { Component, OnInit } from '@angular/core';
import { VendorService} from 'src/app/Vendor.service';

@Component({
  selector: 'app-vendorpendingorders',
  templateUrl: './vendorpendingorders.component.html',
  styleUrls: ['./vendorpendingorders.component.css']
})
export class VendorpendingordersComponent implements OnInit {
  private orderhistory;
  vendorService:VendorService;
  //private value:any;  
  private str: String;
  private orderId:any;
  private itemId:any;
 // private status:String;
  private status ="ACCEPTED";
  constructor(vendorService:VendorService)
  {
    this.vendorService = vendorService;
   }

  ngOnInit() {
    let venId = localStorage.getItem('venId');
    this.vendorService.getPendingOrders(venId)
    .subscribe(response=> {
        this.orderhistory =response;
        console.log(this.orderhistory)
    });
  }

update(comments, d) {
  // this.value= + selectedk;
  // if(this.value==1)
  // {
  //   this.status="ACCEPTED";
  // }
  // else{
  //   this.status="DENIED";
  // }
  this.str= comments;
  this.orderId= d.orderId;
  this.itemId= d.orderItemId;
  console.log("Selected orderId: ", this.orderId);
  console.log("Selected itemid: ", this.itemId);
  console.log("status:"+this.status);
  console.log("Comment:"+this.str);
  let venId = localStorage.getItem('venId');
  this.vendorService.updateOrder(venId, this.status, this.orderId, this.itemId, this.str)
     .subscribe((response)=> console.log(response));
     window.alert("order is updated");
     window.location.reload();
}

onTest()
    {
  if (document.getElementById('onToggleswitchId').click) {
    this.status= "ACCEPTED"
    console.log(this.status)
  }
  }
offTest()
{
  if (document.getElementById('offToggleswitchId').click) {
    this.status= "DENIED"
    console.log(this.status)
  }
}
}