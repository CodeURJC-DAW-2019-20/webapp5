import { Games } from './games';
import { Time } from '@angular/common';
import { EventRegister } from './event-register';
import { Tournaments } from './tournaments';

export interface Events {
	id: number;
	game: Games;
	name: string;
	place: string;
	date: Date;
	time: Time;
	description: string;
	isTournament: boolean;
	haveImage: boolean;
	tournament?: Tournaments;
	groupSize: number;
	inscriptionFee: number;
	maxParticipants: number;
	registrations: EventRegister[];
}
