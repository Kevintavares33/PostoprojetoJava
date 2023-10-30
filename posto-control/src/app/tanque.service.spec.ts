import { TestBed } from '@angular/core/testing';

import { TanqueService } from './tanque.service';

describe('TanqueService', () => {
  let service: TanqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TanqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
