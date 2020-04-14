import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventTemplateComponent } from './event-template.component';

describe('EventTemplateComponent', () => {
  let component: EventTemplateComponent;
  let fixture: ComponentFixture<EventTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
