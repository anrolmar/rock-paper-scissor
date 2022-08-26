package com.projects.backend.services;

import org.springframework.stereotype.Service;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;
import com.projects.backend.domain.model.GameResult;

@Service
public class GameServiceImpl implements GameService {

	@Override
	public GameResult performGame(Choice playerChoice) throws Exception {

		Choice computerChoice = getComputerChoice();

		Result result = Result.DRAW;
		if (playerChoice.isBetterThan(computerChoice)) {
			result = Result.WIN;
		} else if (computerChoice.isBetterThan(playerChoice)) {
			result = Result.LOOSE;
		}

		return new GameResult(playerChoice, computerChoice, result);
	}

	private Choice getComputerChoice() {
		return Choice.getRandom();
	}

}
