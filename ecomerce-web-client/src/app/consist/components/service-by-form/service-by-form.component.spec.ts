import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceByFormComponent } from './service-by-form.component';

describe('ServiceByFormComponent', () => {
  let component: ServiceByFormComponent;
  let fixture: ComponentFixture<ServiceByFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceByFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceByFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
