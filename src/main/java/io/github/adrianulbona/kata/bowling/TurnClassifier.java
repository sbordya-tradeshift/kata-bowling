package io.github.adrianulbona.kata.bowling;

import java.util.function.Function;

import static io.github.adrianulbona.kata.bowling.Turn.Type.REGULAR;
import static io.github.adrianulbona.kata.bowling.Turn.Type.SPARE;
import static io.github.adrianulbona.kata.bowling.Turn.Type.STRIKE;

/**
 * Created by adrianulbona on 23/02/2017.
 */
public class TurnClassifier implements Function<Turn, Turn.Type> {

	@Override
	public Turn.Type apply(Turn turn) {
		if (turn.firstThrow() == 10) {
			return STRIKE;
		}
		if (turn.firstThrow() + turn.secondThrow() == 10) {
			return SPARE;
		}
		return REGULAR;
	}
}
