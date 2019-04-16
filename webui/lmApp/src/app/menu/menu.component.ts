import { Component, OnInit } from 'node_modules/@angular/core';
import { MenuService } from '../menu.service';
import { Menu } from '../model/Menu';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, OnDestroy {

  private menuService: MenuService;
  private menu;
  private status:String;
  private output:Menu[] = [];

  constructor(menuService:MenuService) {
    this.menuService = menuService;
   }

   ngOnInit() { 
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = response;
      console.log(this.menu);
      
    })
    
  }
  filter(selectedType) {
    if(selectedType==1) {
      this.menuService.getAllMenu()
      .subscribe(response=> {
        this.menu = this.menu.sort(function(obj1, obj2){return obj1.menPrice - obj2.menPrice;})
      console.log(this.menu);
    });
  }
  else if(selectedType==2) {
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu.sort(function(a, b){return b.menPrice-a.menPrice});
      console.log(this.menu);
    });
  }
  else if(selectedType==3) {
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = this.menu.sort(function(obj1, obj2){return obj1.menCalories - obj2.menCalories;})
      console.log(this.menu);
    });
  }
  else if(selectedType==4) {
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = response;
      console.log(this.menu);
      
    })
}
  }

onTest()
    {
  if (document.getElementById('onToggleswitchId').click) {
    this.status= "VEG"
    console.log(this.status)
    this.menuService.getAllMenu()
    .subscribe(response=> {
      this.menu = response;
  this.output = [];
 for (var i = 0; i < this.menu.length; i++) {
 if(this.menu[i].menSpeciality == "VEG"){
 this.output.push(this.menu[i]);
 }
 }
 this.menu = this.output;
});
  }
 console.log(this.menu);
  }
  

offTest()
{
  if (document.getElementById('offToggleswitchId').click) {
    this.status= "NON-VEG"
    console.log(this.status)
    this.menuService.getAllMenu()
    .subscribe(response=>  {
      this.menu = response;
      this.output = [];
 for (var i = 0; i < this.menu.length; i++) {
 if(this.menu[i].menSpeciality == "NON-VEG"){
 this.output.push(this.menu[i]);
 }
 }
 this.menu = this.output;
});
  }
  console.log(this.menu);
  }



  ngOnDestroy() {
    console.log('Called before destroying the component....');
  }

}
