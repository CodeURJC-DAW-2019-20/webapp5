import { Users } from './users';

export interface Roles {
	id: number;
	name: string;
	users?: Users[];
}
