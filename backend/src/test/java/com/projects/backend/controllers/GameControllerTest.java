package com.projects.backend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;
import com.projects.backend.domain.model.GameResult;
import com.projects.backend.services.GameServiceImpl;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

	@InjectMocks
	private GameController gameController;

	@Mock
	private GameServiceImpl gameServiceMock;

	@Test
	public void shouldPerformAGame() throws Exception {

		// Given
		Choice playerChoice = Choice.PAPER;
		Result result = Result.WIN;
		GameResult mockGameResult = new GameResult(playerChoice, Choice.ROCK, result);
		when(gameServiceMock.performGame(playerChoice)).thenReturn(mockGameResult);

		// When
		GameResult gameResult = gameController.performGame(playerChoice.name());

		// Then
		assertNotNull(gameResult);
		assertEquals(gameResult.getPlayerChoice(), playerChoice);
		assertEquals(gameResult.getComputerChoice(), Choice.ROCK);
		assertEquals(gameResult.getResult(), result);

	}

	@Test
	public void shouldThrowErrorWhenTheOptionIsWrong() throws Exception {
		// Given
		String playerChoice = "tree";

		// When
		// Then
		try {
			gameController.performGame(playerChoice);
		} catch (Exception ex) {
			assertNotNull(ex);
			assertInstanceOf(HttpClientErrorException.class, ex);
			assertEquals("400 Option not allowed", ex.getMessage());
			assertEquals(((HttpClientErrorException) ex).getRawStatusCode(), HttpStatus.BAD_REQUEST.value());
		}

	}

}
