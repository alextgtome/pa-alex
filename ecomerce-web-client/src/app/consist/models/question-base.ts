import { QuestionOption } from './question-option';
import { Validators } from '@angular/forms';

export class QuestionBase<T> {
    value: T;
    key: string;
    label: string;
    required: boolean;
    order: number;
    controlType: string;
    type: string;
    cssClass: string;
    options: QuestionOption[];
    placeholder: string;
    nominal: boolean;
    showLabel: boolean;
    validators: any[]
    mask: string;
    multiple: boolean;
    enum: boolean;

    constructor(options: {
        value?: T,
        key?: string,
        label?: string,
        required?: boolean,
        order?: number,
        controlType?: string,
        type?: string,
        cssClass?: string,
        mask?: string,
        placeholder?: string
        nominal?: boolean
        showLabel?: boolean
        validators?: Validators[]
    } = {}) {
        this.value = options.value;
        this.key = options.key || '';
        this.label = options.label || '';
        this.required = !!options.required;
        this.order = options.order === undefined ? 1 : options.order;
        this.controlType = options.controlType || '';
        this.type = options.type || '';
        this.cssClass = options.cssClass || '';
        this.mask = options.mask || '';
        this.placeholder = options['placeholder'] || '';
        this.validators = options['validators'] || null;
        this.nominal = options['nominal'] || false;
        this.showLabel = options['showLabel'] || false;
    }
}
