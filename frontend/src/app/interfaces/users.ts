import { Roles } from './roles';
import { Purchase } from './purchase';
import { EventRegister } from './event-register';


export interface Users {
	id: number;
	email: string;
	name: string;
	firstName: string;
	lastName: string;

	password?: string;
	role?: Roles;

	purchases?: Purchase[];
	events?: EventRegister[];
}
