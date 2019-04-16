import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { CustomerwalletComponent } from './customerwallet.component';

describe('CustomerwalletComponent', () => {
  let component: CustomerwalletComponent;
  let fixture: ComponentFixture<CustomerwalletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerwalletComponent ],
      imports:[HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerwalletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
