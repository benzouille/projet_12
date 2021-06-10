import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssoBureauComponent } from './asso-bureau.component';

describe('AssoBureauComponent', () => {
  let component: AssoBureauComponent;
  let fixture: ComponentFixture<AssoBureauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssoBureauComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssoBureauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
