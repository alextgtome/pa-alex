import { QuestionBase } from './question-base';

export class SlideToggleQuestion extends QuestionBase<string> {
  controlType = 'slide-toggle';

  constructor(options: {} = {}) {
    super(options);
  }
}