import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vendordashboard',
  templateUrl: './vendordashboard.component.html',
  styleUrls: ['./vendordashboard.component.css']
})
export class VendordashboardComponent implements OnInit {

  constructor(private router:ActivatedRoute) { }

  ngOnInit() {
    let venId = this.router.snapshot.params.id;
    localStorage.setItem('venId', venId);
  }

}
