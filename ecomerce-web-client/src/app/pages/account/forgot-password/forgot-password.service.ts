import { Injectable } from '@angular/core';
import { ForgotPassword } from '../../../shared/classes/forgot-password';
import { AbstractService } from '../../../consist/abstracts/abstract-service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService extends AbstractService<ForgotPassword>  {

  constructor(private _httpClient: HttpClient) {
    super(_httpClient)
  }
}
