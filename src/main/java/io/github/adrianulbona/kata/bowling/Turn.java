package io.github.adrianulbona.kata.bowling;

import lombok.Data;

/**
 * Created by adrianulbona on 23/02/2017.
 */
@Data
public class Turn {

	private final int firstThrow;
	private final int secondThrow;

	public int total() {
		return this.firstThrow + this.secondThrow;
	}

	public enum Type {
		REGULAR, SPARE, STRIKE
	}

	public static Turn strike() {
		return new Turn(10, 0);
	}

	public static Turn spare(int firstThrow) {
		return new Turn(firstThrow, 10 - firstThrow);
	}

	public static Turn regular(int firstThrow, int secondThrow) {
		return new Turn(firstThrow, secondThrow);
	}
}
