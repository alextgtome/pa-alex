import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceByDataSearchComponent } from './service-by-data-search.component';

describe('ServiceByDataSearchComponent', () => {
  let component: ServiceByDataSearchComponent;
  let fixture: ComponentFixture<ServiceByDataSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceByDataSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceByDataSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
