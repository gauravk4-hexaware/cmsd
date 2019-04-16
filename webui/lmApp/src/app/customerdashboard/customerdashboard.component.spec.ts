import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerdashboardComponent } from './customerdashboard.component';
import {RouterTestingModule} from '@angular/router/testing';
import {FormsModule} from '@angular/forms';
import { CustomerorderhistoryComponent } from '../customerorderhistory/customerorderhistory.component';
import { CustomerComponent } from '../customer/customer.component';
import { PlaceorderComponent } from '../placeorder/placeorder.component';
import { CustomerwalletComponent } from '../customerwallet/customerwallet.component';
import {NgxPaginationModule} from 'ngx-pagination';
describe('CustomerdashboardComponent', () => {
  let component: CustomerdashboardComponent;
  let fixture: ComponentFixture<CustomerdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerdashboardComponent,
                      CustomerdashboardComponent,
                      CustomerorderhistoryComponent,
                      CustomerComponent,
                      PlaceorderComponent,
                      CustomerwalletComponent
                    ],
      imports: [FormsModule, NgxPaginationModule, RouterTestingModule.withRoutes([
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
       ],
      )]
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

