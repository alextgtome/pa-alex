import { Validators } from '@angular/forms';

export const loginFormFile = [
    {
        key: 'identification',
        label: 'EMAIL',
        placeholder: 'EMAIL',
        controlType: 'textbox',
        showLabel: true,
        type: 'text',
        cssClass: 'col-md-12',
        validators: [
            Validators.required,
            Validators.pattern(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)
        ],
        required: true,
        order: 1
    },
    {
        key: 'password',
        label: 'PASSWORD',
        placeholder: 'password',
        controlType: 'textbox',
        type: 'password',
        cssClass: 'col-md-12',
        showLabel: true,
        validators: [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(20)
        ],
        required: true,
        order: 2
    },

];
