
export class PriceCompositionModel {

    id: string;
    name: string;
    description: string;

    constructor(priceComposition?) {
        priceComposition = priceComposition || {};

        this.id = priceComposition.id || null;
        this.name = priceComposition.name || null;
        this.description = priceComposition.description || null;
    }
}
