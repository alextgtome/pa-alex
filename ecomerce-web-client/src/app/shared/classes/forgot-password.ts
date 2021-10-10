export class ForgotPassword {
    email: string;
    constructor(email) {
        email = email || {};
        this.email = email.email || '';
    }
}
