import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  readLocalStorage(key):string{
    return localStorage.getItem(key);
  }
  clear() {
    localStorage.clear();
  }
}