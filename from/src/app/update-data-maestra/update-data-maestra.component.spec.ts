import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDataMaestraComponent } from './update-data-maestra.component';

describe('UpdateDataMaestraComponent', () => {
  let component: UpdateDataMaestraComponent;
  let fixture: ComponentFixture<UpdateDataMaestraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDataMaestraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDataMaestraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
