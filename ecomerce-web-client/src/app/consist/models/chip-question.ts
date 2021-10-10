import { QuestionBase } from './question-base';

export class ChipQuestion extends QuestionBase<string> {
  controlType = 'chip';
  type: string;
  selectable: boolean;
  removable: boolean;
  visible: boolean;
  
  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
    this.selectable = options['selectable'] || true;
    this.removable = options['removable'] || true;
    this.visible = options['visible'] || true;
  }
}