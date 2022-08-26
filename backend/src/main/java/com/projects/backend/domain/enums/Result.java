package com.projects.backend.domain.enums;

public enum Result {
	DRAW(0),

	LOOSE(2),

	WIN(1);

	private final Integer value;

	public Integer getValue() {
		return value;
	}

	Result(Integer value) {
		this.value = value;
	}
}
