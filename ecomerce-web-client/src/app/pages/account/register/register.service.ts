import { Injectable } from '@angular/core';
import { QuestionBase } from 'src/app/consist/models/question-base';
import { AbstractService } from 'src/app/consist/abstracts/abstract-service';
import { HttpClient } from '@angular/common/http';
import { ClientAccountRegistry } from '../../../shared/classes/client-account-registry';

@Injectable({
  providedIn: 'root'
})
export class RegisterService extends AbstractService<ClientAccountRegistry> {

  constructor(private _httpClient: HttpClient) {
    super(_httpClient)
  }

}
