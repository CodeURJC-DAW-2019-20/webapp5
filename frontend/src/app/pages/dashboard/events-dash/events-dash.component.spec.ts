import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventsDashComponent } from './events-dash.component';

describe('EventsDashComponent', () => {
  let component: EventsDashComponent;
  let fixture: ComponentFixture<EventsDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventsDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventsDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
