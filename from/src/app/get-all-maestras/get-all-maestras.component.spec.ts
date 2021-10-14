import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllMaestrasComponent } from './get-all-maestras.component';

describe('GetAllMaestrasComponent', () => {
  let component: GetAllMaestrasComponent;
  let fixture: ComponentFixture<GetAllMaestrasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllMaestrasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllMaestrasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
