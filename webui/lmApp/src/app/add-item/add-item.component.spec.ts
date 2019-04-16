import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AddItemComponent } from './add-item.component';
import {RouterTestingModule} from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import {FormsModule} from '@angular/forms';

describe('AddItemComponent', () => {
  let component: AddItemComponent;
  let fixture: ComponentFixture<AddItemComponent>;
  let router:Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddItemComponent ],
      imports:[RouterTestingModule, FormsModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});