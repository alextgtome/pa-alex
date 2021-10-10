import { Injectable, NgModule } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@Injectable()
export class HttpsRequestInterceptor implements HttpInterceptor {

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler,
  ): Observable<HttpEvent<any>> {
    let ReqDuplicada;
    const session = JSON.parse(localStorage.getItem('session'));
    if (session !== null) {
      if (req.url.indexOf('login') === -1 ) {
        const token = session.token;
        ReqDuplicada = req.clone({
          headers: req.headers.set('Authorization', 'Bearer '  + token).set('Content-Type', 'application/json')
        });
      } else {
        ReqDuplicada = req.clone({});
      }
      return next.handle(ReqDuplicada);
    } else {
      ReqDuplicada = req.clone({});
    }
    return next.handle(ReqDuplicada);
  }
}

@NgModule({
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpsRequestInterceptor,
      multi: true,
    },
  ],
})
export class InterceptorModule { }
