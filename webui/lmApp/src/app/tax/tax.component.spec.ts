import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import { TaxComponent } from './tax.component';
import {HttpClientModule} from '@angular/common/http';
describe('TaxComponent', () => {
  let component: TaxComponent;
  let fixture: ComponentFixture<TaxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TaxComponent ],
      imports: [FormsModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TaxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
