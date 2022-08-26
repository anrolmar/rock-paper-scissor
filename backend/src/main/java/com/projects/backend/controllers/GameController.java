package com.projects.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.model.GameResult;
import com.projects.backend.services.GameServiceImpl;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

	@Autowired
	private GameServiceImpl gameService;

	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public GameResult performGame(@RequestParam("choice") String choice) throws Exception {

		try {
			Choice playerChoice = Choice.valueOf(choice.toUpperCase());
			return gameService.performGame(playerChoice);
		} catch (IllegalArgumentException ex) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Option not allowed");
		}
	}

}
