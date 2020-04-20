import { Events } from './events';

export interface Games {
	id: number;
	name: string;
	acronym: string;
	events: Events[];
	
}
