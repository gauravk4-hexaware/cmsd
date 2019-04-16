import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';

import { VendororderhistoryComponent } from './vendororderhistory.component';

describe('VendororderhistoryComponent', () => {
  let component: VendororderhistoryComponent;
  let fixture: ComponentFixture<VendororderhistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendororderhistoryComponent ],
      imports:[NgxPaginationModule,HttpClientModule]
  

    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendororderhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
