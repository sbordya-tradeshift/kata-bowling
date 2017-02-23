package io.github.adrianulbona.kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.github.adrianulbona.kata.bowling.Turn.*;
import static java.lang.Integer.valueOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by adrianulbona on 23/02/2017.
 */
class ScoreCalculatorTest {

	private ScoreCalculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new ScoreCalculator();
	}

	@Test
	public void testStrikes() {
		final List<Turn> turns = range(0, 12)
				.mapToObj(ignored -> strike())
				.collect(toList());
		assertEquals(valueOf(300), this.calculator.apply(turns));
	}

	@Test
	public void test9miss() {
		final List<Turn> turns = range(0, 10)
				.mapToObj(ignored -> regular(9, 0))
				.collect(toList());
		assertEquals(valueOf(90), this.calculator.apply(turns));
	}

	@Test
	public void testSpares() {
		final List<Turn> turns = range(0, 11)
				.mapToObj(ignored -> spare(5))
				.collect(toList());
		assertEquals(valueOf(150), this.calculator.apply(turns));
	}
}
