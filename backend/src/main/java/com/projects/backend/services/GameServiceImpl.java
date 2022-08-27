package com.projects.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;
import com.projects.backend.domain.model.GameResult;

@Service
public class GameServiceImpl implements GameService {

	Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

	@Override
	public GameResult performGame(Choice playerChoice) throws Exception {

		try {
			Choice computerChoice = getComputerChoice();

			Result result = Result.DRAW;
			if (playerChoice.isBetterThan(computerChoice)) {
				result = Result.WIN;
			} else if (computerChoice.isBetterThan(playerChoice)) {
				result = Result.LOOSE;
			}

			return new GameResult(playerChoice, computerChoice, result);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	private Choice getComputerChoice() {
		return Choice.getRandom();
	}

}
