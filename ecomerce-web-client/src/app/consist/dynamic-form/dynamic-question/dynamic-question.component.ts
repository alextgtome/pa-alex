import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { QuestionBase } from '../../models/question-base';

@Component({
  selector: 'dynamic-form',
  templateUrl: './dynamic-question.component.html',
  styleUrls: ['./dynamic-question.component.scss']
})
export class DynamicQuestionComponent implements OnInit {

  @Input() question: QuestionBase<string>;
  @Input() form: FormGroup;
  get isValid() { return this.form.controls[this.question.key].valid; }

  constructor() { }

  ngOnInit() {
  }

}
