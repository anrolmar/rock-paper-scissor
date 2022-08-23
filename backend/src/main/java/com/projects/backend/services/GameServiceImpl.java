package com.projects.backend.services;

import org.springframework.stereotype.Service;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;

@Service
public class GameServiceImpl implements GameService {

	@Override
	public Result performGame(Choice playerChoice) throws Exception {

		Choice computerChoice = getComputerChoice();

		Result result = Result.DRAW;
		if (playerChoice.isBetterThan(computerChoice)) {
			result = Result.WIN;
		} else if (computerChoice.isBetterThan(playerChoice)) {
			result = Result.LOOSE;
		}
		return result;
	}

	private Choice getComputerChoice() {
		return Choice.getRandom();
	}

}
