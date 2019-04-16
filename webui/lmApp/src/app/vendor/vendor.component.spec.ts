import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorComponent } from './vendor.component';
import {HttpClientModule} from '@angular/common/http';
describe('VendorComponent', () => {
  let component: VendorComponent;
  let fixture: ComponentFixture<VendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorComponent ],
      imports: [HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
