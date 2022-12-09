import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShappersComponent } from './shappers.component';

describe('ShappersComponent', () => {
  let component: ShappersComponent;
  let fixture: ComponentFixture<ShappersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShappersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShappersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
