import { Users } from './users';
import { Events } from './events';

export interface EventRegister {
	id: number;
	user: Users;
	event: Events;
	inscriptionName: string;
	participantNumber: number;
}
