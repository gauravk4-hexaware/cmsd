import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './customer.component';

describe('CustomerComponent', () => {
  let component: CustomerComponent;
  let fixture: ComponentFixture<CustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerComponent ],
      imports:[HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});