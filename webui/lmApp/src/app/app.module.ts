import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { MenuComponent } from './menu/menu.component';
import { VendorComponent } from 'src/app/vendor/vendor.component';
import { LoginComponent } from './login/login.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { VendorloginComponent } from './vendorlogin/vendorlogin.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { VendordashboardComponent } from './vendordashboard/vendordashboard.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { CustomerorderhistoryComponent } from './customerorderhistory/customerorderhistory.component';
import { VendororderhistoryComponent } from './vendororderhistory/vendororderhistory.component';
import { CustomerwalletComponent } from './customerwallet/customerwallet.component';
import { VendorpendingordersComponent } from './vendorpendingorders/vendorpendingorders.component';
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { BillRecieptComponent } from './bill-reciept/bill-reciept.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { AddItemComponent } from './add-item/add-item.component';
import { RemoveItemComponent } from './remove-item/remove-item.component';
import { TaxComponent } from './tax/tax.component';
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    MenuComponent,
    VendorComponent,
    LoginComponent,
    CustomerloginComponent,
    VendorloginComponent,
    VendordashboardComponent,
    CustomerdashboardComponent,
    CustomerorderhistoryComponent,
    VendororderhistoryComponent,
    CustomerwalletComponent,
    VendorpendingordersComponent,
    PlaceorderComponent,
    BillRecieptComponent,
    AddItemComponent,
    RemoveItemComponent,
    TaxComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    RouterModule.forRoot([
      {
        path:'login',
        component:LoginComponent,
        children:[
          {
            path:'customerlogin',
            component:CustomerloginComponent
          },
          {
            path:'vendorlogin',
            component:VendorloginComponent
          },
          {
            path:'customerlogin',
            component:CustomerloginComponent
          }
        ]
        
      },
      {
        path:'',
        component:MenuComponent
      },
      {
        path:'vendors/:id/dashboard',
        component:VendordashboardComponent,
        children:[
          {
            path:'',
            component:VendorComponent
          },
          {
            path:'Vendor',
            component:VendorComponent
          },
          {
            path:'orderhistory',
            component:VendororderhistoryComponent
          },
          {
            path:'vendorpendingorders',
            component:VendorpendingordersComponent
          },
          {
            path:'additem',
            component:AddItemComponent
          },
          {
            path:'removeitem',
            component:RemoveItemComponent
          },
          {
            path:'taxCalculation',
            component:TaxComponent
          }
        ]
      },

      {
        path:'customers/:id/dashboard',
        component:CustomerdashboardComponent,
        children:[
          {
            path:'',
            component:CustomerComponent
          },
          {
            path:'Customer',
            component:CustomerComponent
          },
          {
            path:'orderhistory',
            component:CustomerorderhistoryComponent
          },
          {
            path:'placeorder',
            component:PlaceorderComponent
          },
          {
            path:'customerwallet',
            component:CustomerwalletComponent
          },


        ]
      },

      {
        path:'Customer/bill',
        component:BillRecieptComponent
      },

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
