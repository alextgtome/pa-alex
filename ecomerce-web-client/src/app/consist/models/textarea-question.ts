import { QuestionBase } from './question-base';

export class TextareaQuestion extends QuestionBase<string> {
    controlType = 'textarea';
    type: string;
    rows: number;
  
    constructor(options: {} = {}) {
      super(options);
      this.type = options['type'] || '';
      this.rows = Number.parseInt(options['rows']) || 10;
    }
}
