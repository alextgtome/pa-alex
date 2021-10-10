import { Component, OnInit } from '@angular/core';
import { DashboardService } from './dashboard.service';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public openDashboard: boolean = false;

  constructor(
    private service: DashboardService,
    private toastrService: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  ToggleDashboard() {
    this.openDashboard = !this.openDashboard;
  }

  logout(): void {
    this.service.get(environment.endpoint + environment.authentication + '/access/logout').then((response) => {
      this.service.removeSession();
      this.toastrService.success(`Logout efetuado!`);
      this.router.navigate(['home']);
    }).catch((error) => {
      this.service.removeSession();
      this.toastrService.error(`Sessão inválida.`);
      this.router.navigate(['home']);
    });
  }

}
