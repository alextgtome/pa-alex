import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {
  
  public themeLogo: string = 'assets/images/icon/' + environment.registrOfficer + '.png'; // Change Logo

  constructor() { }

  ngOnInit(): void {
  }

}
