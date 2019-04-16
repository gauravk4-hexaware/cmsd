import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import {Menu} from '../model/Menu';

@Component({
  selector: 'app-remove-item',
  templateUrl: './remove-item.component.html',
  styleUrls: ['./remove-item.component.css']
})
export class RemoveItemComponent implements OnInit {
  private menuService: MenuService;
  private menu;
  private output: Menu[] = [];
  private foodId:number;

  constructor(menuService:MenuService) {
    this.menuService = menuService;
   }

  ngOnInit() {
    this.menuService.fetchMenuAdd()
    .subscribe(response=> {
      this.menu = response;
      var flags = [], l = this.menu.length, i;
        for( i=0; i<l; i++) {
        if( this.menu[i].venId == localStorage.getItem('venId')){
          this.output.push(this.menu[i]);
        }
      }
      console.log("output",this.output);
      this.menu = this.output;
    });
  }
  foodOptionSelected(selectedFoodId){
    this.foodId = +selectedFoodId;
    console.log("id"+this.foodId);
    };
    update() {
      let venId = localStorage.getItem('venId');
      console.log("id:"+this.foodId);
      console.log("venid:"+venId);
      this.menuService.deleteVenMen(venId, this.foodId)
     .subscribe((response)=> console.log(response));
     window.alert("Item removed");
     window.location.reload();
    }
}
