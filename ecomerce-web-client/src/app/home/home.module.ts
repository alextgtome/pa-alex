import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { HomeComponent } from './home/home.component';
import { HomeRoutingModule } from './home-routing.module';
import { BlogComponent } from './widgets/blog/blog.component';
import { CollectionComponent } from './widgets/collection/collection.component';
import { InstagramComponent } from './widgets/instagram/instagram.component';
import { LogoComponent } from './widgets/logo/logo.component';
import { ServicesComponent } from './widgets/services/services.component';
// Widgest Components
import { SliderComponent } from './widgets/slider/slider.component';



@NgModule({
  declarations: [
    HomeComponent,
    // Widgest Components
    SliderComponent,
    BlogComponent,
    LogoComponent,
    InstagramComponent,
    ServicesComponent,
    CollectionComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule
  ]
})
export class HomeModule { }
