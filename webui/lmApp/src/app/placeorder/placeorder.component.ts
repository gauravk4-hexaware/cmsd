import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { CustomerService } from '../customer.service';
import { Wallet } from '../model/Wallet';
import { Router } from '@angular/router';
import { Menu } from '../model/Menu';

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {
private vendors;
private menu;
private wallet;
private foodId:number;
private selectedVendorId:number;
private price:number;
private quantity:number;
private cusId:number;
private total:number;
private venId:number;
private wallId:number;
private wall;
private wallTotal:number;
private orders;
private output: Menu[] = [];   
  constructor(private menuService:MenuService, private customerService:CustomerService, private router:Router) { }

    ngOnInit() {
      this.menuService.getAllMenu()
      .subscribe(response=> {
        this.menu = response;
        console.log(this.menu);
        this.menu = this.menu.filter(response => response.menId !== this.menu.menId);
        var flags = [], l = this.menu.length, i;
        for( i=0; i<l; i++) {
        if( flags[this.menu[i].menId]) continue;
        flags[this.menu[i].menId] = true;
        this.output.push(this.menu[i]);
      }
      console.log("output",this.output);
      this.menu = this.output;
      });

      this.customerService.getCustomersWallet(localStorage.getItem("cusId"))
      .subscribe(response => {
        this.wall =response;
        console.log(this.wall);
        this.wallTotal = 0;
        for (var i = 0; i < this.wall.length; i++) {
          this.wallTotal+= this.wall[i].walletAmount;
    }
    console.log("sum is"+this.wallTotal)
      });

  }
  foodOptionSelected(selectedFoodId){
    this.foodId = +selectedFoodId;
    this.menuService.fetchVendors(selectedFoodId)
    .subscribe(vendors => {
      this.vendors = vendors;
      console.log(this.vendors);

    });
}
  VendorIdSelected(selected){
    console.log(selected);
    this.price=+selected.menPrice;
    console.log("price"+this.price);
    console.log(selected.menPrice);
    this.venId = +selected.venId;
    let venName = selected.venName
    localStorage.setItem('venName', venName);
    let menItem = selected.menItem;
    localStorage.setItem('menItem', menItem);
    let menPrice = selected.menPrice;
    localStorage.setItem('menPrice', menPrice);
    window.alert("Vendor selected"+venName);

  }


  calulateTotalPrice(selected) {
    this.quantity=selected;
    let qty = selected;
    localStorage.setItem('qty', qty);
    console.log("quantity"+this.quantity);
    this.total = (this.quantity)*(this.price);
    console.log("total"+this.total);
    this.cusId=+localStorage.getItem("cusId");
    console.log("cusId"+this.cusId);
    this.customerService.getWallet(this.cusId)
    .subscribe(wallet => {
      this.wallet = wallet;
      console.log(this.wallet);
      this.wallet = this.wallet.filter(wallet => wallet.walletAmount > this.total);
      console.log("valid");
      console.log(this.wallet);
    });

  }

  walletId(selected) {
    this.wallId = +selected;
    console.log("walletId"+this.wallId);
    this.wallTotal = this.wallTotal - this.total;
    for (var i = 0; i < this.wall.length; i++){
      if(this.wall[i].walletId === this.wallId) {
        console.log("inside if", this.wall[i]);
        console.log(this.wall)
       this.wall[i].walletAmount = this.wall[i].walletAmount - this.total;
        console.log("after"+this.wall[i].walletAmount);
        let wallSource =this.wall[i].walletSource;
        localStorage.setItem('wallSource', wallSource);

  }
}
}

  submit(form) {
    console.log("inside submit")
     this.customerService.placeOrder(this.cusId, this.venId,this.wallId,this.foodId,this.quantity,this.total)
      .subscribe(response => {
        this.orders = response;
        console.log("orders",this.orders);
        console.log("here")
        localStorage.setItem('orderId', this.orders.orderId);
        localStorage.setItem('orderDate', this.orders.orderDate);
        window.alert("order placed");
        this.router.navigate(['/Customer/bill']);
        
      });


 }
}
