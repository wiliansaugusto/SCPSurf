import { TestBed } from '@angular/core/testing';

import { ServicosGenericosService } from './servicos-genericos.service';

describe('ServicosGenericosService', () => {
  let service: ServicosGenericosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicosGenericosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
