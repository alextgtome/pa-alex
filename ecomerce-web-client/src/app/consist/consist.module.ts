import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';
import { NgxMaskModule } from 'ngx-mask';
import { AdditionalServiceDataComponent } from './components/additional-service-data/additional-service-data.component';
import { ServiceByDataSearchComponent } from './components/service-by-data-search/service-by-data-search.component';
import { ServiceByFormComponent } from './components/service-by-form/service-by-form.component';
import { ServiceByImageFileComponent } from './components/service-by-image-file/service-by-image-file.component';
import { DynamicQuestionComponent } from './dynamic-form/dynamic-question/dynamic-question.component';
import { InterceptorModule } from './interceptor/interceptor.module';
import { CurrencyFormatPipe } from './pipe/currency-format.pipe';
import { ReduceIdPipe } from './pipe/reduce-id.pipe';
import { ReplaceLineBreaksPipe } from './pipe/replace-line-breaks.pipe';
import { ResumeLineBreakPipe } from './pipe/resume-line-break.pipe';
import { TableListComponent } from "./components/table-list/table-list.component";
import { NgxLoaderIndicatorModule } from 'ngx-loader-indicator';

const declarations = [
  CurrencyFormatPipe,
  ReduceIdPipe,
  ReplaceLineBreaksPipe,
  ResumeLineBreakPipe,
  DynamicQuestionComponent,
  ServiceByFormComponent,
  ServiceByImageFileComponent,
  ServiceByDataSearchComponent,
  AdditionalServiceDataComponent,
  TableListComponent
]

const imports = [
  CommonModule,
  InterceptorModule,
  ReactiveFormsModule,
  NgBootstrapFormValidationModule,
  NgbModule,
  TranslateModule,
  NgxMaskModule,
  FormsModule,
  RouterModule,
  NgxLoaderIndicatorModule 
]

const entryComponents = [
]

@NgModule({
  declarations: declarations,
  imports: imports,
  exports: declarations,
  entryComponents: entryComponents
})
export class ConsistModule { }