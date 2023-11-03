import { TestBed } from '@angular/core/testing';

import { BombaService } from './bomba.service';

describe('BombaService', () => {
  let service: BombaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BombaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
