package com.projects.backend.services;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;

public interface GameService {

	Result performGame(Choice playerChoice) throws Exception;

}
