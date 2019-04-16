import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import { RemoveItemComponent } from './remove-item.component';
import {HttpClientModule} from '@angular/common/http';
describe('RemoveItemComponent', () => {
  let component: RemoveItemComponent;
  let fixture: ComponentFixture<RemoveItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveItemComponent ],
      imports: [FormsModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
