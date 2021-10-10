import { Validators } from '@angular/forms';

export const forgotPasswordFile = [
    {
        key: 'email',
        label: 'EMAIL',
        showLabel: false,
        placeholder: 'EMAIL',
        controlType: 'textbox',
        type: 'text',
        cssClass: 'col-md-6',
        validators: [
            Validators.required,
            Validators.pattern(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)
        ],
        required: true,
        order: 1
    }
];
