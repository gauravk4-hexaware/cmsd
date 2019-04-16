import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import {Menu} from '../model/Menu';
//import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  private menuService: MenuService;
  private menu;
  private output: Menu[] = [];
  private outputnew: Menu[] = [];
  private price:any;
  private foodId:any;
  private numb:number;
  private menuItem:Menu[] = [];
  private flag:boolean;
  private flags:boolean;

  constructor(menuService:MenuService) {
    this.menuService = menuService;
   }

   ngOnInit() {
    this.menuService.fetchMenuAdd()
    .subscribe(response=> {
      this.menu = response;
      /*var flags = [], l = this.menu.length, i;
        for( i=0; i<l; i++) {
        if( flags[this.menu[i].menId]) continue;
        flags[this.menu[i].menId] = true;
        this.output.push(this.menu[i]);*/
        this.numb = +localStorage.getItem('venId')
        for(var i=0;i<this.menu.length; i++){
          if(this.menu[i].venId === this.numb){
            this.menuItem.push(this.menu[i].menItem);
          }
        }
        for(var i=0;i<this.menu.length;i++){
          this.flag = false;
          if(this.menu[i].venId !== this.numb){
            for(var j=0;j<this.menuItem.length;j++){
              if(this.menuItem[j] == this.menu[i].menItem){
                this.flag = true; break
              }
            }
            if(this.flag === false){
              this.output.push(this.menu[i]);
            }
          }
        }
        this.menu = this.output;
        var l = this.menu.length;
        console.log("see menItem",this.menu);
        for( var i=0; i<l; i++) {
          this.flags = false;
          for(var j=0;j<l; j++){
            if(this.menu[j].menItem == this.menu[i].menItem && i!==j){
              this.flags = true;
            }
          }
          if(this.flags === false){
            this.outputnew.push(this.menu[i]);
          }
      }
      this.menu = this.outputnew;
      console.log(this.outputnew)
    });
    
  }

  foodOptionSelected(selectedFoodId){
    this.foodId = +selectedFoodId;
    console.log("id"+this.foodId);
    };
    update(price) {
      this.price= price;
      let venId = localStorage.getItem('venId');
      console.log("price:"+this.price);
      console.log("id:"+this.foodId);
      console.log("venid:"+venId);
      this.menuService.insertMenu(venId, this.foodId, this.price)
     .subscribe((response)=> console.log(response));
     window.alert("item-updated");
     window.location.reload();
    }

  // ngOnDestroy() {
  //   console.log('Called before destroying the component....');
  // }
}
