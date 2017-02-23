package io.github.adrianulbona.kata.bowling;

import lombok.Data;

import java.util.function.Predicate;
import java.util.stream.Stream;

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

	public static Turn strike() {
		return new Turn(10, 0);
	}

	public static Turn spare(int firstThrow) {
		return new Turn(firstThrow, 10 - firstThrow);
	}

	public static Turn regular(int firstThrow, int secondThrow) {
		return new Turn(firstThrow, secondThrow);
	}

	public enum Type {
		STRIKE(turn -> turn.firstThrow() == 10),
		SPARE(turn -> turn.firstThrow() + turn.secondThrow() == 10),
		REGULAR(turn -> turn.firstThrow() + turn.secondThrow() < 10);

		private final Predicate<Turn> detector;

		Type(Predicate<Turn> detector) {
			this.detector = detector;
		}

		public static Type of(Turn turn) {
			return Stream.of(values())
					.filter(type -> type.detector.test(turn))
					.findFirst()
					.orElseThrow(IllegalArgumentException::new);
		}
	}
}
