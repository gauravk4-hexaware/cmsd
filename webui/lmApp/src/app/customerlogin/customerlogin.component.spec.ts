import { async, ComponentFixture, TestBed, inject } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {RouterTestingModule} from '@angular/router/testing';
import { CustomerloginComponent } from './customerlogin.component';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { Router } from '@angular/router';

describe('CustomerloginComponent', () => {
  let component: CustomerloginComponent;
  let fixture: ComponentFixture<CustomerloginComponent>;
  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerloginComponent ],
      imports:[FormsModule, RouterTestingModule, HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', async(inject([HttpTestingController], 
    (httpMock: HttpTestingController) => {
   expect(component).toBeTruthy();
    }
 )
 ));
});
