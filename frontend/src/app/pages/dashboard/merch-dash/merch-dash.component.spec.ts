import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchDashComponent } from './merch-dash.component';

describe('MerchDashComponent', () => {
  let component: MerchDashComponent;
  let fixture: ComponentFixture<MerchDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
