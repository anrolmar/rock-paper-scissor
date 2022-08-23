package com.projects.backend.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;
import com.projects.backend.services.GameServiceImpl;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

	private static String[] AVAILABLE_CHOICES = { Choice.PAPER.name(), Choice.ROCK.name(), Choice.SCISSORS.name() };

	@Autowired
	private GameServiceImpl gameService;

	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public Result performGame(@RequestParam("choice") String choice) throws Exception {

		Choice playerChoice = Choice.valueOf(choice.toUpperCase());
		if (!Arrays.asList(AVAILABLE_CHOICES).contains(playerChoice.name()))
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Option not allowed");
		return gameService.performGame(playerChoice);
	}

}
