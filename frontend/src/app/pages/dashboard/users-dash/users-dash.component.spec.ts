import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersDashComponent } from './users-dash.component';

describe('UsersDashComponent', () => {
  let component: UsersDashComponent;
  let fixture: ComponentFixture<UsersDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
