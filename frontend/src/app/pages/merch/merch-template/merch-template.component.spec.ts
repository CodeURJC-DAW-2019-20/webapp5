import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchTemplateComponent } from './merch-template.component';

describe('MerchTemplateComponent', () => {
  let component: MerchTemplateComponent;
  let fixture: ComponentFixture<MerchTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
