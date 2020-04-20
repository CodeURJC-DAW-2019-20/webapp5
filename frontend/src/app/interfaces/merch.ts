import { MerchType } from './merch-type';
import { Purchase } from './purchase';

export interface Merch {
	id: number;
	merchType: MerchType;
	name: string;
	price: number;
	discount?: number;
	stock: number;
	description: string;
	haveImage: boolean;
	purchases?: Purchase[];
}
