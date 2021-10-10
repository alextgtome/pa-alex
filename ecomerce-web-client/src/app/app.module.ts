import { registerLocaleData } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import ptBr from '@angular/common/locales/pt';
import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoadingBarHttpClientModule } from '@ngx-loading-bar/http-client';
import { LoadingBarRouterModule } from '@ngx-loading-bar/router';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import 'hammerjs';
import 'mousetrap';
import { CUSTOM_ERROR_MESSAGES, NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';
import { NgxLoaderIndicatorModule } from 'ngx-loader-indicator';
import { NgxMaskModule } from 'ngx-mask';
import { ToastrModule } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConsistModule } from './consist/consist.module';
import { CUSTOM_ERRORS } from './consist/models/messages-errors';
import { ElementsComponent } from './elements/elements.component';
import { GraphQLModule } from './graphql.module';
import { PagesComponent } from './pages/pages.component';
import { SharedModule } from './shared/shared.module';
import { ShopComponent } from './shop/shop.component';

registerLocaleData(ptBr)

// AoT requires an exported function for factories
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}

const loaderOptions = {
  // tslint:disable-next-line:max-line-length
  img: 'data:image/svg+xml;base64,PHN2ZyBjbGFzcz0ibGRzLXNwaW5uZXIiIHdpZHRoPSIzOXB4IiAgaGVpZ2h0PSIzOXB4IiAgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmlld0JveD0iMCAwIDEwMCAxMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89InhNaWRZTWlkIiBzdHlsZT0iYmFja2dyb3VuZDogbm9uZTsiPjxnIHRyYW5zZm9ybT0icm90YXRlKDAgNTAgNTApIj4gIDxyZWN0IHg9IjQ3LjUiIHk9Ii0zLjUiIHJ4PSIwLjk1MDAwMDAwMDAwMDAwMDEiIHJ5PSItMC4wNyIgd2lkdGg9IjUiIGhlaWdodD0iMjciIGZpbGw9IiNGOTc3NTYiPiAgICA8YW5pbWF0ZSBhdHRyaWJ1dGVOYW1lPSJvcGFjaXR5IiB2YWx1ZXM9IjE7MCIga2V5VGltZXM9IjA7MSIgZHVyPSIxcyIgYmVnaW49Ii0wLjkxNjY2NjY2NjY2NjY2NjZzIiByZXBlYXRDb3VudD0iaW5kZWZpbml0ZSI+PC9hbmltYXRlPiAgPC9yZWN0PjwvZz48ZyB0cmFuc2Zvcm09InJvdGF0ZSgzMCA1MCA1MCkiPiAgPHJlY3QgeD0iNDcuNSIgeT0iLTMuNSIgcng9IjAuOTUwMDAwMDAwMDAwMDAwMSIgcnk9Ii0wLjA3IiB3aWR0aD0iNSIgaGVpZ2h0PSIyNyIgZmlsbD0iI0Y5Nzc1NiI+ICAgIDxhbmltYXRlIGF0dHJpYnV0ZU5hbWU9Im9wYWNpdHkiIHZhbHVlcz0iMTswIiBrZXlUaW1lcz0iMDsxIiBkdXI9IjFzIiBiZWdpbj0iLTAuODMzMzMzMzMzMzMzMzMzNHMiIHJlcGVhdENvdW50PSJpbmRlZmluaXRlIj48L2FuaW1hdGU+ICA8L3JlY3Q+PC9nPjxnIHRyYW5zZm9ybT0icm90YXRlKDYwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC43NXMiIHJlcGVhdENvdW50PSJpbmRlZmluaXRlIj48L2FuaW1hdGU+ICA8L3JlY3Q+PC9nPjxnIHRyYW5zZm9ybT0icm90YXRlKDkwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC42NjY2NjY2NjY2NjY2NjY2cyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMTIwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC41ODMzMzMzMzMzMzMzMzM0cyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMTUwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC41cyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMTgwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC40MTY2NjY2NjY2NjY2NjY3cyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMjEwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC4zMzMzMzMzMzMzMzMzMzMzcyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMjQwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSItMC4yNXMiIHJlcGVhdENvdW50PSJpbmRlZmluaXRlIj48L2FuaW1hdGU+ICA8L3JlY3Q+PC9nPjxnIHRyYW5zZm9ybT0icm90YXRlKDI3MCA1MCA1MCkiPiAgPHJlY3QgeD0iNDcuNSIgeT0iLTMuNSIgcng9IjAuOTUwMDAwMDAwMDAwMDAwMSIgcnk9Ii0wLjA3IiB3aWR0aD0iNSIgaGVpZ2h0PSIyNyIgZmlsbD0iI0Y5Nzc1NiI+ICAgIDxhbmltYXRlIGF0dHJpYnV0ZU5hbWU9Im9wYWNpdHkiIHZhbHVlcz0iMTswIiBrZXlUaW1lcz0iMDsxIiBkdXI9IjFzIiBiZWdpbj0iLTAuMTY2NjY2NjY2NjY2NjY2NjZzIiByZXBlYXRDb3VudD0iaW5kZWZpbml0ZSI+PC9hbmltYXRlPiAgPC9yZWN0PjwvZz48ZyB0cmFuc2Zvcm09InJvdGF0ZSgzMDAgNTAgNTApIj4gIDxyZWN0IHg9IjQ3LjUiIHk9Ii0zLjUiIHJ4PSIwLjk1MDAwMDAwMDAwMDAwMDEiIHJ5PSItMC4wNyIgd2lkdGg9IjUiIGhlaWdodD0iMjciIGZpbGw9IiNGOTc3NTYiPiAgICA8YW5pbWF0ZSBhdHRyaWJ1dGVOYW1lPSJvcGFjaXR5IiB2YWx1ZXM9IjE7MCIga2V5VGltZXM9IjA7MSIgZHVyPSIxcyIgYmVnaW49Ii0wLjA4MzMzMzMzMzMzMzMzMzMzcyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PGcgdHJhbnNmb3JtPSJyb3RhdGUoMzMwIDUwIDUwKSI+ICA8cmVjdCB4PSI0Ny41IiB5PSItMy41IiByeD0iMC45NTAwMDAwMDAwMDAwMDAxIiByeT0iLTAuMDciIHdpZHRoPSI1IiBoZWlnaHQ9IjI3IiBmaWxsPSIjRjk3NzU2Ij4gICAgPGFuaW1hdGUgYXR0cmlidXRlTmFtZT0ib3BhY2l0eSIgdmFsdWVzPSIxOzAiIGtleVRpbWVzPSIwOzEiIGR1cj0iMXMiIGJlZ2luPSIwcyIgcmVwZWF0Q291bnQ9ImluZGVmaW5pdGUiPjwvYW5pbWF0ZT4gIDwvcmVjdD48L2c+PC9zdmc+',
  loaderStyles: {
    'position': 'absolute',
    'left': '0',
    'right': '0',
    'top': '0',
    'bottom': '0',
    'background': 'rgba(255, 255, 255, 0.6)',
    'z-index': '50',
    'display': 'flex',
    'justify-content': 'center',
    'align-items': 'center',
  },
  imgStyles: {
    'width': '30px',
  },
  hostStyles: {
    'position': 'relative'
  },
  rotate: {
    iterations: Infinity
  },
}

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    PagesComponent,
    ElementsComponent,
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    NgBootstrapFormValidationModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule,
    NgbModule,
    LoadingBarHttpClientModule,
    LoadingBarRouterModule,
    ToastrModule.forRoot({
      timeOut: 1000,
      progressBar: false,
      enableHtml: true,
    }),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    NgxLoaderIndicatorModule.forRoot(loaderOptions),
    NgxMaskModule.forRoot(),
    SharedModule,
    AppRoutingModule,
    ConsistModule,
    GraphQLModule,
  ],
  providers: [
    {
      provide: CUSTOM_ERROR_MESSAGES,
      useValue: CUSTOM_ERRORS,
      multi: true
    },
    {
      provide: LOCALE_ID, useValue: 'pt-BR'
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
