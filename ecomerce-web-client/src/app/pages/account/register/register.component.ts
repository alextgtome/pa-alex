import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { QuestionBase } from 'src/app/consist/models/question-base';
import { QuestionControlService } from 'src/app/consist/services/question-control-service.service';
import { RegisterService } from 'src/app/pages/account/register/register.service';
import { registerFormFile } from 'src/assets/forms/register-form';
import { environment } from 'src/environments/environment';
import { Login } from 'src/app/shared/classes/login';
import { ClientAccountRegistry } from 'src/app/shared/classes/client-account-registry';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;
  isLoading: boolean;

  questions: QuestionBase<string>[] = [];

  constructor(
    private service: RegisterService,
    private toastrService: ToastrService,
    private router: Router,
    private qcs: QuestionControlService,) {
  }

  ngOnInit(): void {
    this.questions = this.service.getQuestions(registerFormFile);
    this.form = this.qcs.toFormGroup(this.questions);
  }


  register(): void {
    this.isLoading = true;
    const clientAccountRegistry = new ClientAccountRegistry(this.form.getRawValue());
    const md5 = require('md5');
    clientAccountRegistry.password = md5(clientAccountRegistry.password);
    clientAccountRegistry.passwordRetyped = md5(clientAccountRegistry.passwordRetyped);
    this.service.post(environment.endpoint + environment.accounts + '/client-account/auth', clientAccountRegistry).then((response) => {
      this.router.navigate(['pages', 'login']);
      this.toastrService.success(`Cadastrado com sucesso! Faça login!`);
    }).catch((error) => {
      this.toastrService.error(`Erro ao realizar login.`);
    }).finally(() => {
      this.isLoading = false;
    });
  }

}
