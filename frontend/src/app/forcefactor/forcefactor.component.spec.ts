import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForceFactorComponent } from './forcefactor.component';

describe('ForcefactorComponent', () => {
  let component: ForceFactorComponent;
  let fixture: ComponentFixture<ForceFactorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForceFactorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForceFactorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
