export enum Result {
  DRAW = 'DRAW',
  LOOSE = 'LOOSE',
  WIN = 'WIN',
}

export enum Choice {
  PAPER = 'PAPER',
  ROCK = 'ROCK',
  SCISSORS = 'SCISSORS',
}

export interface GameResult {
  playerChoice: Choice;
  computerChoice: Choice;
  result: Result;
}
