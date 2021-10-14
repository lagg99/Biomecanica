import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailDataMaestraComponent } from './detail-data-maestra.component';

describe('DetailDataMaestraComponent', () => {
  let component: DetailDataMaestraComponent;
  let fixture: ComponentFixture<DetailDataMaestraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailDataMaestraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailDataMaestraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
