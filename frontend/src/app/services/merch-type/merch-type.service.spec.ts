import { TestBed } from '@angular/core/testing';

import { MerchTypeService } from './merch-type.service';

describe('MerchTypeService', () => {
  let service: MerchTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MerchTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
