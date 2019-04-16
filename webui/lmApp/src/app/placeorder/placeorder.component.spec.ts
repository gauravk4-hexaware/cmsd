import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceorderComponent } from './placeorder.component';
import {FormsModule} from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientModule} from '@angular/common/http';
describe('PlaceorderComponent', () => {
  let component: PlaceorderComponent;
  let fixture: ComponentFixture<PlaceorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaceorderComponent ],
      imports: [FormsModule, HttpClientModule, RouterTestingModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaceorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
