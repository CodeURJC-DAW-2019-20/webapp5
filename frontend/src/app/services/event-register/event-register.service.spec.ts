import { TestBed } from '@angular/core/testing';

import { EventRegisterService } from './event-register.service';

describe('EventRegisterService', () => {
  let service: EventRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
