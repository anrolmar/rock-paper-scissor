package com.projects.backend.services;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.model.GameResult;

public interface GameService {

	GameResult performGame(Choice playerChoice) throws Exception;

}
