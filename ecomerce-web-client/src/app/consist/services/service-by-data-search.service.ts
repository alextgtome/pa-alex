import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';
import { AbstractService } from '../abstracts/abstract-service';
import { ServiceProvidedModel } from '../models/service-provided-model';

@Injectable({
  providedIn: 'root'
})
export class ServiceByDataSearchService extends AbstractService<any>{

  constructor(private _httpClient: HttpClient,
    private apollo: Apollo,) {
    super(_httpClient);
  }


  searchServiceData(filter: any): Promise<any> {
    return this.search(this.apollo, 'teste', this.createQuery(filter));
  }

  createQuery(filter: any) {
    return {
      query: gql` query data($filter: ServiceDataOptionsFilter)
      {
        service:searchDataByService(filter: $filter) {
          data
        }
      } 
    `, variables: { filter: filter }


    }
  }

}
