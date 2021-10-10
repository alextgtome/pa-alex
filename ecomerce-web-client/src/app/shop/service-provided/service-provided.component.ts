import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { QuestionOption } from 'src/app/consist/models/question-option';
import { ServiceProvidedPriceModel } from 'src/app/shared/classes/ServiceProvidedPriceModel';
import { ServiceProvidedService } from './service-provided.service';

@Component({
  selector: 'app-service-provided',
  templateUrl: './service-provided.component.html',
  styleUrls: ['./service-provided.component.scss']
})
export class ServiceProvidedComponent implements OnInit {

  service: ServiceProvidedPriceModel;
  private _unsubscribeAll: Subject<any>;
  enableSearchRequest = false;
  enableFormRequest = false;
  enableImageRequest = false;
  searchPropertiesOptions: Array<QuestionOption>;
  requestType: string;
  additionalStep = false;

  constructor(
    private router: Router,
    private _service: ServiceProvidedService) {
    this._unsubscribeAll = new Subject();
  }

  ngOnInit(): void {
    this._service.onChanged
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(service => {
        this.service = new ServiceProvidedPriceModel(service);
        this.service.serviceProvided.endpoint ? this.enableSearchRequest = true : this.enableSearchRequest = false
        this.service.serviceProvided.serviceQuestions ? this.enableFormRequest = true : this.enableFormRequest = false
        this.service.serviceProvided.serviceImageOption ? this.enableImageRequest = true : this.enableImageRequest = false

        this.requestType = 'none';
        this.additionalStep = false;
        if (this.enableSearchRequest) {
          // set fields options
          this.searchPropertiesOptions = new Array<QuestionOption>();
          // TEMPORÁRIO
          this.searchPropertiesOptions.push(new QuestionOption("pesquisaNome", "Nome Registrado"));
          this.searchPropertiesOptions.push(new QuestionOption("pesquisaNomePai", "Nome do Pai"));
          this.searchPropertiesOptions.push(new QuestionOption("pesquisaNomeMae", "Nome da Nãe"));
        }
      }, () => {
        this.router.navigateByUrl('/pages/404', { skipLocationChange: true });
      });
  }

  // Add to cart
  async addToCart(service: any) {
    // product.quantity = this.counter || 1;
    // const status = await this.productService.addToCart(product);
    // if (status)
    //   this.router.navigate(['/shop/cart']);
  }

  // Buy Now
  async buyNow(service: any) {
    // product.quantity = this.counter || 1;
    // const status = await this.productService.addToCart(product);
    // if (status)
    //   this.router.navigate(['/shop/checkout']);
  }

  changeRequestType(requestType) {
    requestType !== this.requestType && requestType !== 'none' ? this.requestType = requestType : this.requestType = 'none';
  }

  selectData(actionEvent: any): void {
    // criar item para adicionar ao carrinho
    console.log(actionEvent);
    this.requestType = "finished"

    // ir para os serviços adicionais
    this.additionalStep = true
  }

}
