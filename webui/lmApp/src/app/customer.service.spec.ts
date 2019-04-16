import { TestBed, inject, async, getTestBed } from '@angular/core/testing';

import { CustomerService } from './customer.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { Customer } from './model/Customer';
describe('CustomerServicetesting', () => {

  let injector;
  let service:CustomerService;
  let customerService:CustomerService;
  let httpMock: HttpTestingController;
 
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers: [CustomerService]
    });
    injector= getTestBed();
    service=injector.get(CustomerService);
    httpMock=injector.get(HttpTestingController);
  });
  beforeEach(inject([CustomerService],(service:CustomerService)=>{
    customerService = service;
  }));
  afterEach(()=>{
    httpMock.verify();
  })
  it('should be created', () => {
    const service: CustomerService = TestBed.get(CustomerService);
    expect(service).toBeTruthy();
  });

  describe('#getAllCustomers',() => {
    it('test fetching customer by ID', () =>{
      const customer:Customer[]=[
        new Customer(1, "Jennifa Francis","8971736796","jennifa@gmail.com","JennifaN","justin18@"),
      ];
    service.getAllCustomers(1).subscribe(customer=>{
      console.log('jhkfsdhjkfdhjkfdhjkfdshjkfd')
      console.log(customer);
    });
    const request=httpMock.expectOne('http://localhost:8080/FTP112/api/customer/1');
    expect(request.request.method).toBe("GET");
    request.flush(customer);
  })
})
  describe('#getCustomersWallet',() => {
  it('test fetching wallet by cusId', () =>{
    const customer:Customer[]=[
      new Customer(1, "Jennifa Francis","8971736796","jennifa@gmail.com","JennifaN","justin18@"),
    ];
  service.getCustomersWallet(1).subscribe(customer=>{
    console.log('jhkfsdhjkfdhjkfdhjkfdshjkfd')
    console.log(customer);
  });
  const request=httpMock.expectOne('http://localhost:8080/FTP112/api/customer/1/wallet');
  expect(request.request.method).toBe("GET");
  request.flush(customer);
})
})

});
