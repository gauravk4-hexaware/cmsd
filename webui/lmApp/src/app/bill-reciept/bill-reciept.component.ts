import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bill-reciept',
  templateUrl: './bill-reciept.component.html',
  styleUrls: ['./bill-reciept.component.css']
})
export class BillRecieptComponent implements OnInit {
  private cusId:String;
  private menItem:String;
  private menPrice:String;
  private name:String;
  private wallSource:String;
  private venName:String;
  private qty:String;
  private email:String;
  private total:number;
  private phoneNo:string;
  private orderId:string;
  private orderDate:string;
  private username:string
  constructor() {
  
   }

  ngOnInit() {
    this.orderId = localStorage.getItem('orderId');
    this.orderDate = localStorage.getItem('orderDate');
    this.cusId = localStorage.getItem('cusId');
    this.menItem = localStorage.getItem('menItem');
    this.menPrice = localStorage.getItem('menPrice');
    this.name = localStorage.getItem('name');
    this.wallSource = localStorage.getItem('wallSource');
    this.venName = localStorage.getItem('venName');
    this.qty = localStorage.getItem('qty');
    this.email = localStorage.getItem('ename');
    this.phoneNo = localStorage.getItem('phoneNo');
    this.total = (+this.qty)*(+this.menPrice);
    this.username = localStorage.getItem('userName');
    console.log("ngOnit me hu me")
  }

}
