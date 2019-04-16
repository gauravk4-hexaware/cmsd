import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent implements OnInit , OnDestroy {

  constructor(private router:ActivatedRoute) { 
    let cusId = this.router.snapshot.params.id;
    localStorage.setItem('cusId', cusId);
  }

  ngOnInit() {
    console.log("me hu dashboad vo bhi customer")
  }

  ngOnDestroy(){
    console.log('destroying customer dashboard');
  }
}
