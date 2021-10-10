import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { Ng5SliderModule } from 'ng5-slider';
import { NgxPayPalModule } from 'ngx-paypal';
import { SharedModule } from '../shared/shared.module';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { SuccessComponent } from './checkout/success/success.component';
import { CollectionComponent } from './collection/collection.component';
import { BrandsComponent } from './collection/widgets/brands/brands.component';
import { ColorsComponent } from './collection/widgets/colors/colors.component';
import { GridComponent } from './collection/widgets/grid/grid.component';
import { PaginationComponent } from './collection/widgets/pagination/pagination.component';
import { PriceComponent } from './collection/widgets/price/price.component';
import { SizeComponent } from './collection/widgets/size/size.component';
import { ProductComponent } from './product/product.component';
import { CountdownComponent } from './product/widgets/countdown/countdown.component';
import { RelatedProductComponent } from './product/widgets/related-product/related-product.component';
import { ServicesComponent } from './product/widgets/services/services.component';
import { SocialComponent } from './product/widgets/social/social.component';
import { StockInventoryComponent } from './product/widgets/stock-inventory/stock-inventory.component';
import { ShopRoutingModule } from './shop-routing.module';
import { WishlistComponent } from './wishlist/wishlist.component';
import { ServiceProvidedComponent } from './service-provided/service-provided.component';
import { ConsistModule } from '../consist/consist.module';

@NgModule({
  declarations: [
    ProductComponent,
    ServicesComponent,
    CountdownComponent,
    SocialComponent,
    StockInventoryComponent,
    RelatedProductComponent,
    CollectionComponent,
    GridComponent,
    PaginationComponent,
    BrandsComponent,
    ColorsComponent,
    SizeComponent,
    PriceComponent,
    CartComponent,
    WishlistComponent,
    CheckoutComponent,
    SuccessComponent,
    ServiceProvidedComponent
  ],
  imports: [
    CommonModule,
    NgxPayPalModule,
    Ng5SliderModule,
    SharedModule,
    ShopRoutingModule,
    ConsistModule
  ]
})
export class ShopModule { }
