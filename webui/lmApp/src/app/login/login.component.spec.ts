import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import { LoginComponent } from './login.component';
import { Router } from '@angular/router';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let router:Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports:[RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
