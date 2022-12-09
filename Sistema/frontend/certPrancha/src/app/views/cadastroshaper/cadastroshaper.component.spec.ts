import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroshaperComponent } from './cadastroshaper.component';

describe('CadastroshaperComponent', () => {
  let component: CadastroshaperComponent;
  let fixture: ComponentFixture<CadastroshaperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroshaperComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroshaperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
