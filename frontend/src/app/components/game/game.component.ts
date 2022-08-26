import { Component, OnInit } from '@angular/core';

import { GameResult } from '../../types';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss'],
})
export class GameComponent implements OnInit {
  showAttempt: boolean = true;
  showResults: boolean = false;
  gameResult: GameResult | undefined = undefined;

  constructor(private gameService: GameService) {}

  ngOnInit(): void {}

  public handleSelectedChoice(choice: string): void {
    this.showAttempt = false;

    this.gameService
      .performGame(choice)
      .subscribe((data) => (this.gameResult = data));
    setTimeout(() => {
      this.showResults = true;
    }, 1000);
  }

  public handlePlayAgain(): void {
    this.showAttempt = true;
    this.showResults = false;
    this.gameResult = undefined;
  }
}
