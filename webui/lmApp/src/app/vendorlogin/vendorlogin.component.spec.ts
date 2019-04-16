import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorloginComponent } from './vendorlogin.component';
import {FormsModule} from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientModule} from '@angular/common/http';
describe('VendorloginComponent', () => {
  let component: VendorloginComponent;
  let fixture: ComponentFixture<VendorloginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorloginComponent ],
      imports: [FormsModule, RouterTestingModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
