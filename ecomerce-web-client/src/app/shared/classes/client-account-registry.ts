export class ClientAccountRegistry {

    documentId: string;
    email: string;
    fullName: string;
    password: string;
    passwordRetyped: string;
    phoneNumber: string;

    constructor(clientAccountRegistry?) {
        clientAccountRegistry = clientAccountRegistry || {};
        this.email = clientAccountRegistry.email || null;
        this.documentId = clientAccountRegistry.documentId || null;
        this.fullName = clientAccountRegistry.fullName || null;
        this.password = clientAccountRegistry.password || null;
        this.passwordRetyped = clientAccountRegistry.passwordRetyped || null;
        this.phoneNumber = clientAccountRegistry.phoneNumber || null;
    }

}
