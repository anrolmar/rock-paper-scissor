import { Choice, GameResult } from '../../types';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.scss'],
})
export class ResultComponent implements OnInit {
  @Input() gameResult: GameResult | undefined = undefined;
  @Output() playAgainEmitter = new EventEmitter();
  userSelectionImage: string = '';
  computerSelectionImage: string = '';

  constructor() {}

  ngOnInit(): void {
    if (this.gameResult) {
      console.log('GameResult', this.gameResult);
      this.userSelectionImage = this.getImageChoice(
        this.gameResult.playerChoice
      );
      this.computerSelectionImage = this.getImageChoice(
        this.gameResult.computerChoice
      );
    }
  }

  playAgain(): void {
    this.playAgainEmitter.emit();
  }

  private getImageChoice(choice: Choice): string {
    if (choice === Choice.PAPER) return '../../../assets/images/icon-paper.svg';
    else if (choice === Choice.SCISSORS)
      return '../../../assets/images/icon-scissors.svg';
    else return '../../../assets/images/icon-rock.svg';
  }
}
