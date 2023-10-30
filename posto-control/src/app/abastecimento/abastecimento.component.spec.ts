import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbastecimentoComponent } from './abastecimento.component';
import './abastecimento.component.css';


describe('AbastecimentoComponent', () => {
  let component: AbastecimentoComponent;
  let fixture: ComponentFixture<AbastecimentoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AbastecimentoComponent]
    });
    fixture = TestBed.createComponent(AbastecimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
