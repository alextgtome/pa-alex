import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { VideoModalComponent } from "../../shared/components/modal/video-modal/video-modal.component";
import { ProductSlider } from '../../shared/data/slider';
import { ProductService } from '../../shared/services/product.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  public themeLogo: string = 'assets/images/icon/' + environment.registrOfficer + '.png'; // Change Logo

  public ProductSliderConfig: any = ProductSlider;

  @ViewChild("videoModal") VideoModal: VideoModalComponent;

  constructor(public productService: ProductService) {
  }

  // Sliders
  public sliders = [{
    image: 'assets/images/slider/b1.jpg'
  },
  {
    image: 'assets/images/slider/b2.jpg'
  },
  { 
    image: 'assets/images/slider/b3.jpg',
    link: '/shop/collection/right/sidebar'
  }   ];

  ngOnInit(): void {
    // Change color for this layout
    // document.documentElement.style.setProperty('--theme-deafult', '#f0b54d');
  }

  ngOnDestroy(): void {
  }

}
