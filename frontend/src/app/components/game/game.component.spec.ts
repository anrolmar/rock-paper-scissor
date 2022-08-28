import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoiceComponent } from '../choice/choice.component';
import { GameComponent } from './game.component';
import { HttpClientModule } from '@angular/common/http';
import { ResultComponent } from '../result/result.component';

describe('GameComponent', () => {
  let component: GameComponent;
  let fixture: ComponentFixture<GameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
      declarations: [GameComponent, ChoiceComponent, ResultComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(GameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
