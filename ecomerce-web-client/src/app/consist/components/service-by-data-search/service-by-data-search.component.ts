import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ServiceProvidedModel } from 'src/app/consist/models/service-provided-model';
import { searchExample } from "../../../../assets/forms/search-example";
import { QuestionBase } from '../../models/question-base';
import { QuestionOption } from '../../models/question-option';
import { QuestionControlService } from '../../services/question-control-service.service';
import { ServiceByDataSearchService } from '../../services/service-by-data-search.service';

@Component({
  selector: 'app-service-by-data-search',
  templateUrl: './service-by-data-search.component.html',
  styleUrls: ['./service-by-data-search.component.scss']
})
export class ServiceByDataSearchComponent implements OnInit {


  @Input()
  form: FormGroup;
  @Input()
  searchPropertiesOptions: Array<QuestionOption>;
  @Input()
  serviceProvided: ServiceProvidedModel
  @Output()
  dataSelected: EventEmitter<any>;
  isLoading: boolean;
  hasData: any = false;
  data: any;

  page: any = {
    page: 0,
    size: 10
  };

  questions: QuestionBase<string>[] = [];

  constructor(
    private service: ServiceByDataSearchService,
    private toastrService: ToastrService,
    private router: Router,
    private qcs: QuestionControlService) {
    this.dataSelected = new EventEmitter();
  }

  ngOnInit(): void {
    this.questions = this.service.getQuestions(this.createSearchForm());
    this.form = this.qcs.toFormGroup(this.questions);
  }


  createSearchForm() {
    return [{
      key: 'value',
      label: 'SEARCH_DATA',
      showLabel: false,
      placeholder: 'SEARCH_DATA',
      controlType: 'textbox',
      type: 'text',
      cssClass: 'col-md-8',
      validators: [
        Validators.required
      ],
      required: true,
      order: 1
    },
    {
      key: 'property',
      label: 'SEARCH_DATA_RADIO',
      showLabel: true,
      placeholder: 'SEARCH_DATA_RADIO',
      controlType: 'radio',
      type: 'text',
      cssClass: 'col-md-8',
      validators: [
        Validators.required
      ],
      required: true,
      value: this.searchPropertiesOptions[0].key,
      order: 2,
      options: this.searchPropertiesOptions,
      enum: false
    }];
  }

  searchData(): void {
    let filter = {
      endpoint: this.serviceProvided.endpoint,
      serviceId: this.serviceProvided.id,
      value: this.form.get('value').value,
      property: this.form.get('property').value,
      page: this.page.page,
      size: this.page.size
    }
    this.isLoading = true;
    this.data = searchExample;
    // descomentarMock
    // this.service.searchServiceData(filter).then((response) => {
    //   this.data = JSON.parse(response.data.service.data);
    //   if (this.data.recordsFiltered > 0) {
    this.hasData = true;
    //   } else {
    //     this.toastrService.error(`Nenhum resultado encontrado!`);
    //   }
    //   // this.router.navigate(['home']);
    // }).catch((error) => {
    //   this.toastrService.error(`Erro ao realizar login.`);
    // }).finally(() => {
    this.isLoading = false;
    // });
  }

  selectData(actionEvent: any): void {
    this.dataSelected.emit(actionEvent);
  }

}