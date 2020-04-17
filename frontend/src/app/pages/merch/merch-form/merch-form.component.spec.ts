import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchFormComponent } from './merch-form.component';

describe('MerchFormComponent', () => {
  let component: MerchFormComponent;
  let fixture: ComponentFixture<MerchFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
