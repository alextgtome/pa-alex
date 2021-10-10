import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceByImageFileComponent } from './service-by-image-file.component';

describe('ServiceByImageFileComponent', () => {
  let component: ServiceByImageFileComponent;
  let fixture: ComponentFixture<ServiceByImageFileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceByImageFileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceByImageFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
