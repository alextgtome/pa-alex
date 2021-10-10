import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdditionalServiceDataComponent } from './additional-service-data.component';

describe('AdditionalServiceDataComponent', () => {
  let component: AdditionalServiceDataComponent;
  let fixture: ComponentFixture<AdditionalServiceDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdditionalServiceDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdditionalServiceDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
