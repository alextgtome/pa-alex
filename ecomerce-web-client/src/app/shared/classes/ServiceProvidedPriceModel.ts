import { ServiceProvidedModel } from "../../consist/models/service-provided-model";
import { ValuePriceCompositionModel } from "./ValuePriceCompositionModel";

export class ServiceProvidedPriceModel {

    serviceProvided: ServiceProvidedModel;
    valuePriceCompositions: Array<ValuePriceCompositionModel>;
    total: Number;

    constructor(serviceProvidedPrice?) {
        serviceProvidedPrice = serviceProvidedPrice || null;
        this.serviceProvided = serviceProvidedPrice.serviceProvided ? new ServiceProvidedModel(serviceProvidedPrice.serviceProvided) : new ServiceProvidedModel();
        this.valuePriceCompositions = serviceProvidedPrice.valuePriceCompositions ? this.getvaluePriceCompositions(serviceProvidedPrice.valuePriceCompositions) : new Array<ValuePriceCompositionModel>();
        this.total = parseFloat(serviceProvidedPrice.total) || 0
    }

    getvaluePriceCompositions(array: any): Array<ValuePriceCompositionModel> {
        let valuePriceCompositions = new Array<ValuePriceCompositionModel>();

        array.forEach(vpc => {
            valuePriceCompositions.push(new ValuePriceCompositionModel(vpc))
        });
        return valuePriceCompositions;
    }
}
