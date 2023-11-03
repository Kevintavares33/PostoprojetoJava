import { TestBed } from '@angular/core/testing';

import { AbastecimentoService } from './abastecimento.service';

describe('AbastecimentoService', () => {
  let service: AbastecimentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AbastecimentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
