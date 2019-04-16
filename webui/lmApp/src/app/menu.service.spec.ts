import { TestBed, inject, async, getTestBed } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';

import { MenuService } from './menu.service';
import { Menu } from './model/Menu';

describe('MenuService', () => {
  let injector;
  let service:MenuService;
  let vendorService:MenuService;
  let httpMock: HttpTestingController;
  beforeEach(() => { TestBed.configureTestingModule({
    imports:[HttpClientTestingModule],
    providers: [MenuService]
  })
  injector= getTestBed();
  service=injector.get(MenuService);
  httpMock=injector.get(HttpTestingController);
});
beforeEach(inject([MenuService],(service:MenuService)=>{
  vendorService = service;
}));

afterEach(()=>{
  httpMock.verify();
})
describe('#fetchMenuAdd',()=>{
  it('test fetching all the menu',()=>{
      const menu:Menu[]=[
        new Menu(1,'idly', 430, 1, 5,'spr',60, 1,3,2,'divi', 'spicy'),
        new Menu(2,'dosa', 400, 2, 6,'spr',70, 2,4,2,'divya', 'sweet'),

      ];
  
      service.fetchMenuAdd().subscribe(menu=>{
        console.log(menu);
      });
  
      const request=httpMock.expectOne('http://localhost:8080/FTP112/api/Menu/show/');
      expect(request.request.method).toBe("GET");
      request.flush(menu);
  })
})


    describe('#getAllMenu',()=>{
      it('test fetching all the menu',()=>{
          const menu:Menu[]=[
            new Menu(1,"Chicken65",400,1,4,"tasty",300,1,1,2,"Hari","non-veg"),
            new Menu(2,"Chickenbriyani",500,1,4,"tasty",400,1,2,3,"Hari","non-veg")
          ];

          service.getAllMenu().subscribe(menu=>{
            console.log('GetAllMenuTested')
            console.log(menu);
          });
      
          const request=httpMock.expectOne('http://localhost:8080/FTP112/api/Menu/');
          expect(request.request.method).toBe("GET");
          request.flush(menu);
      })
  })

  describe('#fetchVendors',()=>{
    it('test fetching all the menu',()=>{
        const menu:Menu[]=[
          new Menu(1,"Chicken65",400,1,4,"tasty",300,1,1,2,"Hari","non-veg"),
          new Menu(2,"Chickenbriyani",500,1,4,"tasty",400,1,2,3,"Hari","non-veg")
        ];

        service.fetchVendors(1).subscribe(menu=>{
          console.log('FetchVendors')
          console.log(menu);
        });
    
        const request=httpMock.expectOne('http://localhost:8080/FTP112/api/customer/venName/1');
        expect(request.request.method).toBe("GET");
        request.flush(menu);
    })
})

});
