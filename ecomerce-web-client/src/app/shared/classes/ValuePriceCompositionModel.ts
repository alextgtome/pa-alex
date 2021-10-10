import { PriceCompositionModel } from './price-composition-model'
export class ValuePriceCompositionModel {
    priceComposition: PriceCompositionModel;
    value: Number;
    constructor(valuePriceComposition?) {
        valuePriceComposition = valuePriceComposition || null;
        this.priceComposition = valuePriceComposition ? new PriceCompositionModel(valuePriceComposition.priceComposition) : new PriceCompositionModel();
        this.value = parseFloat(valuePriceComposition.value) || 0;
    }

}
