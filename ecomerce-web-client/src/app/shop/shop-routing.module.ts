import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Resolver } from '../shared/services/resolver.service';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { SuccessComponent } from './checkout/success/success.component';
import { CollectionComponent } from './collection/collection.component';
import { ProductComponent } from './product/product.component';
import { ServiceProvidedComponent } from './service-provided/service-provided.component';
import { ServiceProvidedService } from './service-provided/service-provided.service';
import { WishlistComponent } from './wishlist/wishlist.component';

const routes: Routes = [
  {
    path: 'products/:slug',
    component: ProductComponent,
    resolve: {
      data: Resolver
    }
  },
  {
    path: 'services/:id',
    component: ServiceProvidedComponent,
    resolve: {
      data: ServiceProvidedService
    }
  },
  {
    path: 'collection',
    component: CollectionComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: 'wishlist',
    component: WishlistComponent
  },
  {
    path: 'checkout',
    component: CheckoutComponent
  },
  {
    path: 'checkout/success/:id',
    component: SuccessComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopRoutingModule { }
