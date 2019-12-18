import { product } from '../product-item/product';


export interface Offer{
    id: number;
    offerDate: Date;
    offerPercentage: number;
    offerDetails: string;
    productId: product;
}