import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchLineChartComponent } from './merch-line-chart.component';

describe('MerchLineChartComponent', () => {
  let component: MerchLineChartComponent;
  let fixture: ComponentFixture<MerchLineChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchLineChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchLineChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
