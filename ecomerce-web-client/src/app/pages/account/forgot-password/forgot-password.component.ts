import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { QuestionControlService } from '../../../consist/services/question-control-service.service';
import { ForgotPasswordService } from './forgot-password.service';
import { forgotPasswordFile } from 'src/assets/forms/forgot-password';
import { QuestionBase } from '../../../consist/models/question-base';
import { FormGroup } from '@angular/forms';
import { ForgotPassword } from 'src/app/shared/classes/forgot-password';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  form: FormGroup;
  isLoading: boolean;

  questions: QuestionBase<string>[] = [];

  constructor(
    private service: ForgotPasswordService,
    private toastrService: ToastrService,
    private router: Router,
    private qcs: QuestionControlService) { }

  ngOnInit(): void {
    this.questions = this.service.getQuestions(forgotPasswordFile);
    this.form = this.qcs.toFormGroup(this.questions);
  }

  recoverPassword(): void {
    this.isLoading = true;
    const forgotPassword = new ForgotPassword(this.form.getRawValue());
    const md5 = require('md5');
    this.service.patch(`${environment.endpoint}${environment.accounts}/client-account/auth?email=${forgotPassword.email}`, {}).then((response) => {
      this.router.navigate(['home']);
    }).catch((error) => {
      this.toastrService.error(`Erro ao realizar login.`);
    }).finally(() => {
      this.isLoading = false;
    });
  }

}
