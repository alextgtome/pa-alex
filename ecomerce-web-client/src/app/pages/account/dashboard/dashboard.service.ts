import { Injectable } from '@angular/core';
import { AbstractService } from 'src/app/consist/abstracts/abstract-service';
import { ClientAccountRegistry } from 'src/app/shared/classes/client-account-registry';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService extends AbstractService<ClientAccountRegistry> {

  constructor(private _httpClient: HttpClient) {
    super(_httpClient);
  }

  removeSession(): void {
    localStorage.removeItem('session');
  }

}
