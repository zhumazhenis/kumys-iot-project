import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderEntriesComponent } from './order-entries.component';

describe('OrderEntriesComponent', () => {
  let component: OrderEntriesComponent;
  let fixture: ComponentFixture<OrderEntriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderEntriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderEntriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
