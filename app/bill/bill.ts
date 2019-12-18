import { BillDetails } from './billdetails';
import { user } from '../user';


// export interface Bill{
//     userId: number;
//     totalAmount: number;
//     productList : TotalBillDetails[];
//     rewardpoints: number;
//     purchaseDate: Date;
// }
export interface Bill{
    userId: number,
    purchaseDate: Date,
    discountedTotal:number,
    productList: BillDetails[],
    rewardPoints: number,
    userRewardPoints: number
}