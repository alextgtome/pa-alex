import { AdditionalServiceProvidedModel } from './additional-service-provided-model';

export class ServiceProvidedTypeModel {

    id: string;
    name: string;
    description: string;
    status: boolean;
    additionalServicesProvided: Array<AdditionalServiceProvidedModel>

    constructor(serviceProvidedType?) {
        serviceProvidedType = serviceProvidedType || {};
        this.id = serviceProvidedType.id || null;
        this.name = serviceProvidedType.name || '';
        this.description = serviceProvidedType.description || null;
        this.status = serviceProvidedType.status || true;
        this.additionalServicesProvided = serviceProvidedType.additionalServicesProvided ?  this.getAdditionalServicesProvided(serviceProvidedType.additionalServicesProvided): new Array<AdditionalServiceProvidedModel>();
    }

    getAdditionalServicesProvided(array: any): Array<AdditionalServiceProvidedModel>{
        let additionalServicesProvidedList = new Array<AdditionalServiceProvidedModel>();
        array.forEach(element => {
            additionalServicesProvidedList.push(new AdditionalServiceProvidedModel(element))
        });
        return additionalServicesProvidedList;
    }
}
