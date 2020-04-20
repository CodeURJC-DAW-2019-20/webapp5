import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LcddMapComponent } from './lcdd-map.component';

describe('LcddMapComponent', () => {
  let component: LcddMapComponent;
  let fixture: ComponentFixture<LcddMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LcddMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LcddMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
