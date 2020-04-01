import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventsBarChartComponent } from './events-bar-chart.component';

describe('EventsBarChartComponent', () => {
  let component: EventsBarChartComponent;
  let fixture: ComponentFixture<EventsBarChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventsBarChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventsBarChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
