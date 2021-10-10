/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ServiceByDataSearchService } from './service-by-data-search.service';

describe('Service: ServiceByDataSearch', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServiceByDataSearchService]
    });
  });

  it('should ...', inject([ServiceByDataSearchService], (service: ServiceByDataSearchService) => {
    expect(service).toBeTruthy();
  }));
});
