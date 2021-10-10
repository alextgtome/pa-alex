import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { QuestionBase } from 'src/app/consist/models/question-base';
import { Login } from 'src/app/shared/classes/login';
import { loginFormFile } from 'src/assets/forms/login-form';
import { environment } from 'src/environments/environment';
import { QuestionControlService } from '../../../consist/services/question-control-service.service';
import { LoginService } from './login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  isLoading: boolean;

  questions: QuestionBase<string>[] = [];

  constructor(
    private service: LoginService,
    private toastrService: ToastrService,
    private router: Router,
    private qcs: QuestionControlService) {
  }

  ngOnInit(): void {
    this.questions = this.service.getQuestions(loginFormFile);
    this.form = this.qcs.toFormGroup(this.questions);
  }

  login(): void {
    this.isLoading = true;
    const login = new Login(this.form.getRawValue());
    const md5 = require('md5');
    login.password = md5(login.password);
    this.service.post(environment.endpoint + environment.authentication + '/access/login', login).then((response) => {
      this.router.navigate(['home']);
      this.toastrService.success(`Bem vindo ${this.service.setSession(response)}!`);
    }).catch((error) => {
      this.toastrService.error(`Erro ao realizar login.`);
    }).finally(() => {
      this.isLoading = false;
    });
  }

}
