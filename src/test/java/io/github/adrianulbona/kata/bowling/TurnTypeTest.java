package io.github.adrianulbona.kata.bowling;

import org.junit.jupiter.api.Test;

import static io.github.adrianulbona.kata.bowling.Turn.Type.REGULAR;
import static io.github.adrianulbona.kata.bowling.Turn.Type.SPARE;
import static io.github.adrianulbona.kata.bowling.Turn.Type.STRIKE;
import static io.github.adrianulbona.kata.bowling.Turn.regular;
import static io.github.adrianulbona.kata.bowling.Turn.spare;
import static io.github.adrianulbona.kata.bowling.Turn.strike;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by adrianulbona on 23/02/2017.
 */
class TurnTypeTest {

	@Test
	void applyRegular() {
		assertEquals(REGULAR, Turn.Type.of(regular(5, 3)));
	}

	@Test
	void applySpare() {
		assertEquals(SPARE, Turn.Type.of(spare(5)));
	}

	@Test
	void applyStrike() {
		assertEquals(STRIKE, Turn.Type.of(strike()));
	}
}