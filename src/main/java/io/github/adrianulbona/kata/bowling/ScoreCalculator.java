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

	private final Function<Turn, Turn.Type> turnClassifier;

	@Override
	public Integer apply(List<Turn> turns) {
		return range(0, 10)
				.map(index -> {
					final Turn current = turns.get(index);
					final Supplier<Turn> nextSupplier = turnSupplier(turns, index + 1);
					final Supplier<Turn> nextNextSupplier = turnSupplier(turns, index + 2);
					switch (turnClassifier.apply(current)) {
						case REGULAR:
							return regularScore(current);
						case SPARE:
							return spareScore(current, nextSupplier);
						case STRIKE:
							return strikeScore(current, nextSupplier, nextNextSupplier);
						default:
							throw new IllegalArgumentException();
					}
				})
				.sum();
	}

	private int regularScore(Turn current) {
		return current.total();
	}

	private int spareScore(Turn current, Supplier<Turn> nextSupplier) {
		return current.total() + nextSupplier.get().firstThrow();
	}

	private int strikeScore(Turn current, Supplier<Turn> nextSupplier, Supplier<Turn> nextNextSupplier) {
		final Turn nextTurn = nextSupplier.get();
		switch (this.turnClassifier.apply(nextTurn)) {
			case REGULAR:
			case SPARE:
				return current.total() + nextTurn.total();
			case STRIKE:
				return current.total() + nextTurn.total() + nextNextSupplier.get().firstThrow();
			default:
				throw new IllegalArgumentException();
		}
	}

	private Supplier<Turn> turnSupplier(List<Turn> turns, int index) {
		return () -> turns.get(index);
	}
}
