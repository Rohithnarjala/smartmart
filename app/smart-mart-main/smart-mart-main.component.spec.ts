import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartMartMainComponent } from './smart-mart-main.component';

describe('SmartMartMainComponent', () => {
  let component: SmartMartMainComponent;
  let fixture: ComponentFixture<SmartMartMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmartMartMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartMartMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
