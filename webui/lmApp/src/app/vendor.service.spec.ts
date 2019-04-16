import { async, TestBed, inject, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { VendorService } from './vendor.service';
import { Vendor } from './model/Vendor';
import { Menu } from './model/Menu';

describe('VendororderhistoryService', () => {
  let injector;
  let service:VendorService;
  let vendorService:VendorService
  let httpMock: HttpTestingController;

  beforeEach(() => {TestBed.configureTestingModule({
    imports:[HttpClientTestingModule],
    providers:[VendorService]
  })
    injector= getTestBed();
    service=injector.get(VendorService);
    httpMock=injector.get(HttpTestingController);
  });

  beforeEach(inject([VendorService],(service:VendorService)=>{
    vendorService = service;
  }));

  afterEach(()=>{
    httpMock.verify();
  })

  describe('#getVendor',()=>{
    it('test fetching all the vendor',()=>{
        const vendor:Vendor[]=[
          new Vendor(1,"ajay","4543","aj","asdf",2500,1,20),
          new Vendor(2,"manav","4543","mn","asdfg",2500,2,2),
          new Vendor(3,"gaurav","4543","gv","asdfh",2500,3,200),
          new Vendor(4,"palak","4543","pal","asdfj",2500,4,2)
        ];
    
        service.getVendor(1).subscribe(vendor=>{
          console.log('jhkfsdhjkfdhjkfdhjkfdshjkfd')
          console.log(vendor);
        });
    
        const request=httpMock.expectOne('http://localhost:8080/FTP112/api/vendors/1');
        expect(request.request.method).toBe("GET");
        request.flush(vendor);
    })
})
  describe('#getorderhistory',()=>{
    it('test fetching all the vendor',()=>{
        const vendor:Vendor[]=[
          new Vendor(1,"ajay","4543","aj","asdf",2500,1,20),
          new Vendor(2,"manav","4543","mn","asdfg",2500,2,2),
          new Vendor(3,"gaurav","4543","gv","asdfh",2500,3,200),
          new Vendor(4,"palak","4543","pal","asdfj",2500,4,2)
        ];
  
        service.getorderhistory(1).subscribe(vendor=>{
          console.log('jhkfsdhjkfdhjkfdhjkfdshjkfd')
          console.log(vendor);
        });
  
        const request=httpMock.expectOne('http://localhost:8080/FTP112/api/vendors/1/orders');
        expect(request.request.method).toBe("GET");
        request.flush(vendor);
    })
  })
  
  describe('#getPendingOrders',()=>{
    it('test fetching all the vendors',()=>{
        const menu:Menu[]=[
          new Menu(1,'idly', 430, 1, 5,'spr',60, 1,3,2,'divi', 'spicy'),
          new Menu(2,'dosa', 400, 2, 6,'spr',70, 2,4,2,'divya', 'sweet'),
  
        ];
    
        service.getPendingOrders(1).subscribe(menu=>{
          console.log(menu);
        });
    
        const request=httpMock.expectOne('http://localhost:8080/FTP112/api/vendors/1/pending');
        expect(request.request.method).toBe("GET");
        request.flush(menu);
    })
  })


  describe('#getTaxDetails',()=>{
    it('test fetching the tax deatils',()=>{
        const vendor:Vendor[]=[
          new Vendor(1,"ajay","4543","aj","asdf",2500,1,20),
          new Vendor(1,"ajay","4543","aj","asdf",2500,1,20),
  
        ];
    
        service.getTaxDetails(1,3).subscribe(vendor=>{
          console.log(vendor);
        });
    
        const request=httpMock.expectOne('http://localhost:8080/FTP112/api/vendors/1/tax/3');
        expect(request.request.method).toBe("GET");
        request.flush(vendor);
    })
  })
  it('should be created', ()=>{
    expect(service).toBeTruthy();
    expect(vendorService).toBeTruthy();
  });

});
