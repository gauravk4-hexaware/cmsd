import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorpendingordersComponent } from './vendorpendingorders.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
describe('VendorpendingordersComponent', () => {
  let component: VendorpendingordersComponent;
  let fixture: ComponentFixture<VendorpendingordersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorpendingordersComponent ],
      imports: [FormsModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorpendingordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
