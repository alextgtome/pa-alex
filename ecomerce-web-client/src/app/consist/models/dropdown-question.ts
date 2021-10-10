import { QuestionBase } from './question-base';
import { QuestionOption } from './question-option';

export class DropdownQuestion extends QuestionBase<string> {
    controlType = 'dropdown';
    options: QuestionOption[] = [];
    multiple: boolean;
    enum: boolean;

    constructor(options: {} = {}) {
        super(options);
        this.multiple = options['multiple'] || false;
        this.enum = options['enum'] || false;
        this.options = options['options'] || [QuestionOption];
    }
} 