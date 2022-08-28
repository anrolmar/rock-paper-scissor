import { GameResult } from '../types';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  constructor(private http: HttpClient) {}

  performGame(choice: string): Observable<GameResult> {
    return this.http.post<GameResult>(`${environment.apiURL}/games`, null, {
      params: {
        choice,
      },
    });
  }
}
