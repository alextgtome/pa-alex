import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';
import { BehaviorSubject } from 'rxjs';
import { AbstractService } from 'src/app/consist/abstracts/abstract-service';

@Injectable({
  providedIn: 'root'
})
export class ServiceProvidedService extends AbstractService<any> implements Resolve<any>{

  onChanged: BehaviorSubject<any>;

  constructor(
    private router: Router,
    private apollo: Apollo,
    private _httpClient: HttpClient) {
    super(_httpClient);
    this.onChanged = new BehaviorSubject({});
  }

  async resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let query = this.createQuery(route.params.id);
    await this.search(this.apollo, 'services', query).then((response) => {
      if (response.data.service == null)
        throw new Error('Invalid Service');
      this.onChanged.next(response.data.service);
    }).catch((error) => {
      this.router.navigateByUrl('/pages/404', { skipLocationChange: true });
    });
  }

  createQuery(id: String) {
    return {
      query: gql` query data($id: String!)
      {
        service: getServicePrice(id: $id) {
          serviceProvided {
            id
            name
            serviceProvidedType {
              id
              name
              additionalServicesProvided{
                id
                name
              }
            }
            description
            metadata
            averageExecutionTime
            endpoint
            serviceImageOption
            serviceQuestions {
              key
              controlType
              required
              sequence
              placeholder
              required
            }
          }
          valuePriceCompositions {
            priceComposition {
              id
              name
            }
            value
          }
          total
        }
      } 
    `, variables: { id: id }
    }
  }

}
