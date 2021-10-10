export class AdditionalServiceProvidedModel {

    id: string;
    name: string;
    description: string;
    status: boolean;

    constructor(additionalServiceProvided?) {
        additionalServiceProvided = additionalServiceProvided || {};
        this.id = additionalServiceProvided.id || null;
        this.name = additionalServiceProvided.name || '';
        this.description = additionalServiceProvided.description || null;
        this.status = additionalServiceProvided.status || true;
    }
}
