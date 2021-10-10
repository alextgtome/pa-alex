import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.scss']
})
export class PagesComponent implements OnInit {

  public url : any; 
  
  public themeLogo: string = 'assets/images/icon/'+ environment.registrOfficer +'.png';

  constructor(private router: Router) {  
    this.router.events.subscribe((event) => {
          if (event instanceof NavigationEnd) {
            this.url = event.url;
          }
    });
  }

  ngOnInit(): void {
  }

}
