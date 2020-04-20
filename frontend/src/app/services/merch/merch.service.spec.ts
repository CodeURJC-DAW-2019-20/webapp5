import { TestBed } from '@angular/core/testing';

import { MerchService } from './merch.service';

describe('MerchService', () => {
  let service: MerchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MerchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
