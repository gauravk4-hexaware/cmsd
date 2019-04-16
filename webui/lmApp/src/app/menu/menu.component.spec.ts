import { async, ComponentFixture, TestBed ,inject} from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MenuComponent } from './menu.component';
import { AppComponent } from '../app.component';
import { FormsModule } from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
describe('MenuComponent', () => {
  let component: MenuComponent;
  let fixture: ComponentFixture<MenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuComponent, AppComponent ],
      imports: [FormsModule, RouterTestingModule, HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should get users', async(inject([HttpTestingController],
    (httpMock: HttpTestingController) => {
      expect(component).toBeTruthy();
    }
  )
));

});
