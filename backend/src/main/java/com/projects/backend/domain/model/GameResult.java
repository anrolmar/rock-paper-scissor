package com.projects.backend.domain.model;

import com.projects.backend.domain.enums.Choice;
import com.projects.backend.domain.enums.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResult {

	private Choice playerChoice;
	private Choice computerChoice;
	private Result result;

}
