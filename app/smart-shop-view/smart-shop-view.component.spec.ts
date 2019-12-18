import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmartShopViewComponent } from './smart-shop-view.component';

describe('SmartShopViewComponent', () => {
  let component: SmartShopViewComponent;
  let fixture: ComponentFixture<SmartShopViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmartShopViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmartShopViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
