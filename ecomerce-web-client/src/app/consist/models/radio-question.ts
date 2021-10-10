import { QuestionBase } from './question-base';
import { QuestionOption } from './question-option';

export class RadioQuestion extends QuestionBase<string> {
    controlType = 'radio';
    options: QuestionOption[] = [];
    enum: boolean;

    constructor(options: {} = {}) {
        super(options);
        this.enum = options['enum'] || false;
        this.options = options['options'] || [QuestionOption];
    }
} 