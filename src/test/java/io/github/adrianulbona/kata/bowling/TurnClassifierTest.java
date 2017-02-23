package io.github.adrianulbona.kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by adrianulbona on 23/02/2017.
 */
class TurnClassifierTest {

	private TurnClassifier typeClassifier;

	@BeforeEach
	void setUp() {
		this.typeClassifier = new TurnClassifier();

	}

	@Test
	void applyRegular() {
		assertEquals(Turn.Type.REGULAR, this.typeClassifier.apply(new Turn(5, 3)));
	}

	@Test
	void applySpare() {
		assertEquals(Turn.Type.SPARE, this.typeClassifier.apply(new Turn(5, 5)));
	}


	@Test
	void applyStrike() {
		assertEquals(Turn.Type.STRIKE, this.typeClassifier.apply(new Turn(10, 0)));
	}
}