import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AbstractService } from '../../../consist/abstracts/abstract-service';
import { Login } from '../../../shared/classes/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService extends AbstractService<Login> {

  constructor(private _httpClient: HttpClient) {
    super(_httpClient);
  }

  setSession(response: any): string {
    localStorage.setItem('session', JSON.stringify(response));
    const jwtDecode = require('jwt-decode');
    return jwtDecode(response.token).fullName.split(' ', 1)
  }

}
