import { ComponentFixture, TestBed } from '@angular/core/testing';

import { By } from '@angular/platform-browser';
import { ChoiceComponent } from './choice.component';

describe('ChoiceComponent', () => {
  let component: ChoiceComponent;
  let fixture: ComponentFixture<ChoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChoiceComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should emits the paper choice when the user clicks on the paper selection', () => {
    // Given
    const selectChoiceSpy = jest.spyOn(component, 'selectChoice');
    const selectedChoiceEmitterSpy = jest.spyOn(
      component.selectedChoiceEmitter,
      'emit'
    );

    // When
    const paperDiv = fixture.debugElement.query(By.css('.paper'));
    paperDiv.nativeElement.click();

    // Then
    expect(paperDiv).not.toBeNull();
    expect(selectChoiceSpy).toHaveBeenCalledTimes(1);
    expect(selectedChoiceEmitterSpy).toHaveBeenCalledTimes(1);
  });

  it('should emits the rock choice when the user clicks on the rock selection', () => {
    // Given
    const selectChoiceSpy = jest.spyOn(component, 'selectChoice');
    const selectedChoiceEmitterSpy = jest.spyOn(
      component.selectedChoiceEmitter,
      'emit'
    );

    // When
    const rockDiv = fixture.debugElement.query(By.css('.rock'));
    rockDiv.nativeElement.click();

    // Then
    expect(rockDiv).not.toBeNull();
    expect(component.selectChoice).toHaveBeenCalledTimes(1);
    expect(component.selectedChoiceEmitter.emit).toHaveBeenCalledTimes(1);
  });

  it('should emits the scissor choice when the user clicks on the scissor selection', () => {
    // Given
    const selectChoiceSpy = jest.spyOn(component, 'selectChoice');
    const selectedChoiceEmitterSpy = jest.spyOn(
      component.selectedChoiceEmitter,
      'emit'
    );

    // When
    const scissorDiv = fixture.debugElement.query(By.css('.scissors'));
    scissorDiv.nativeElement.click();

    // Then
    expect(scissorDiv).not.toBeNull();
    expect(component.selectChoice).toHaveBeenCalledTimes(1);
    expect(component.selectedChoiceEmitter.emit).toHaveBeenCalledTimes(1);
  });
});
