import { Users } from './users';
import { Merch } from './merch';

export interface Purchase {
	id: number;
	user?: Users;
	merch?: Merch;

	price: number;
	date: Date;	
}
