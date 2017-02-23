package io.github.adrianulbona.kata.bowling;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.IntStream.range;

/**
 * Created by adrianulbona on 23/02/2017.
 */
@RequiredArgsConstructor
public class ScoreCalculator implements Function<List<Turn>, Integer> {

	@Override
	public Integer apply(List<Turn> turns) {
		return range(0, 10).map(index -> score(turns, index)).sum();
	}

	private int score(List<Turn> turns, int index) {
		final Turn currentTurn = turns.get(index);
		final Supplier<Turn> nextSupplier = () -> turns.get(index + 1);
		final Supplier<Turn> nextNextSupplier = () -> turns.get(index + 2);
		switch (Turn.Type.of(currentTurn)) {
			case REGULAR:
				return regularScore(currentTurn);
			case SPARE:
				return spareScore(currentTurn, nextSupplier);
			case STRIKE:
				return strikeScore(currentTurn, nextSupplier, nextNextSupplier);
			default:
				throw new IllegalArgumentException();
		}
	}

	private int regularScore(Turn turn) {
		return turn.total();
	}

	private int spareScore(Turn turn, Supplier<Turn> nextTurnSupplier) {
		return turn.total() + nextTurnSupplier.get().firstThrow();
	}

	private int strikeScore(Turn turn, Supplier<Turn> nextTurnSupplier, Supplier<Turn> nextNextTurnSupplier) {
		final Turn nextTurn = nextTurnSupplier.get();
		switch (Turn.Type.of(nextTurn)) {
			case REGULAR:
			case SPARE:
				return turn.total() + nextTurn.total();
			case STRIKE:
				return turn.total() + nextTurn.total() + nextNextTurnSupplier.get().firstThrow();
			default:
				throw new IllegalArgumentException();
		}
	}
}
