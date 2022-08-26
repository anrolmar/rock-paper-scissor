import { GameResult } from '../types';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  constructor(private http: HttpClient) {}

  performGame(choice: string): Observable<GameResult> {
    return this.http.post<GameResult>(
      'http://localhost:4200/api/v1/games',
      null,
      {
        params: {
          choice,
        },
      }
    );
  }
}
