import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'choice',
  templateUrl: './choice.component.html',
  styleUrls: ['./choice.component.scss'],
})
export class ChoiceComponent implements OnInit {
  @Output() selectedChoiceEmitter = new EventEmitter<string>();

  constructor() {}

  ngOnInit(): void {}

  selectChoice(choice: string): void {
    this.selectedChoiceEmitter.emit(choice);
  }
}
