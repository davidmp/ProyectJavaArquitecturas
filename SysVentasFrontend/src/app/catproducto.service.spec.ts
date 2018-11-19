import { TestBed } from '@angular/core/testing';

import { CatproductoService } from './catproducto.service';

describe('CatproductoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatproductoService = TestBed.get(CatproductoService);
    expect(service).toBeTruthy();
  });
});
