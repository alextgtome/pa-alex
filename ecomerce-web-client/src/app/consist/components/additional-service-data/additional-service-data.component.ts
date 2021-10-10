import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceProvidedTypeModel } from '../../models/service-provided-type-model';

@Component({
  selector: 'app-additional-service-data',
  templateUrl: './additional-service-data.component.html',
  styleUrls: ['./additional-service-data.component.scss']
})
export class AdditionalServiceDataComponent implements OnInit {

  @Input()
  serviceProvidedType: ServiceProvidedTypeModel;

  constructor(
    private router: Router) { }

  ngOnInit(): void {

    console.log(this.serviceProvidedType);
    
  }

}
