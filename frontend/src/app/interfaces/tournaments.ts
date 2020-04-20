import { EventRegister } from './event-register';

export interface Tournaments {
	id: number;
	winner?: EventRegister;
	reward: string;
}
