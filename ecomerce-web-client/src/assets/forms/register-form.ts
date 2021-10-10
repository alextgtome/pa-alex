import { Validators } from '@angular/forms';

export const registerFormFile = [
    {
        key: 'fullName',
        label: 'FULL_NAME',
        placeholder: 'FULL_NAME',
        controlType: 'textbox',
        type: 'text',
        cssClass: 'col-md-6',
        showLabel: true,
        validators: [
            Validators.required,
        ],
        required: true,
        order: 1
    },
    {
        key: 'email',
        label: 'EMAIL',
        placeholder: 'EMAIL',
        controlType: 'textbox',
        showLabel: true,
        type: 'text',
        cssClass: 'col-md-6',
        validators: [
            Validators.required,
            Validators.pattern(/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)
        ],
        required: true,
        order: 2
    },
    {
        key: 'documentId',
        label: 'DOCUMENT_ID',
        placeholder: 'DOCUMENT_ID',
        controlType: 'textbox',
        type: 'text',
        cssClass: 'col-md-6',
        showLabel: true,
        validators: [
            Validators.required,
        ],
        mask: '000.000.000-00',
        required: true,
        order: 3
    },
    {
        key: 'phoneNumber',
        label: 'PHONE_NUMBER',
        placeholder: 'PHONE_NUMBER',
        controlType: 'textbox',
        type: 'text',
        cssClass: 'col-md-6',
        showLabel: true,
        validators: [
            Validators.required,
        ],
        mask: '(00) 00000-0000',
        required: true,
        order: 4
    },
    {
        key: 'password',
        label: 'PASSWORD',
        placeholder: 'PASSWORD',
        controlType: 'textbox',
        type: 'password',
        showLabel: true,
        cssClass: 'col-md-6',
        validators: [
            Validators.required,
            Validators.minLength(8),
            Validators.maxLength(20)
        ],
        required: true,
        order: 5
    },
    {
        key: 'passwordRetyped',
        label: 'PASSWORD_RETYPED',
        placeholder: 'PASSWORD_RETYPED',
        controlType: 'textbox',
        type: 'password',
        showLabel: true,
        cssClass: 'col-md-6',
        validators: [
            Validators.required,
            Validators.minLength(8),
            Validators.maxLength(20)
        ],
        required: true,
        order: 6
    },
];
