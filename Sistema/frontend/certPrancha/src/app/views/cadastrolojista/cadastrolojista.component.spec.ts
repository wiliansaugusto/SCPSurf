import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrolojistaComponent } from './cadastrolojista.component';

describe('CadastrolojistaComponent', () => {
  let component: CadastrolojistaComponent;
  let fixture: ComponentFixture<CadastrolojistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrolojistaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrolojistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
