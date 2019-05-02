package io.github.adrianulbona.kata.bowling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BowlingTest {

    private Bowling bowling = new Bowling(0);

    @Test
    void should_count_num_of_throws_as_20_for_regular_game() {
        bowling.playGame(Arrays.asList(1, 1, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        assertEquals(20,bowling.games.size());
    }

    @Test
    void should_count_num_of_throws_as_21_for_all_spares() {
        bowling.playGame(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
        assertEquals(21,bowling.games.size());
    }

    @Test
    void should_count_num_of_throws_as_12_all_strikes() {
        bowling.playGame(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        assertEquals(12,bowling.games.size());
    }

    @Test
    public void should_add_scores_of_all_throws() {
        List<Integer> games = Arrays.asList(1, 1, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bowling.playGame(games);
        assertEquals(12, bowling.scoreGame(games));
    }

    @Test
    void should_add_score_of_next_throw_for_spares() {
        List<Integer> games = Arrays.asList(1, 1, 4, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bowling.playGame(games);
        assertEquals(14, bowling.scoreGame(games));
    }

    @Test
    void should_add_score_of_next_throw_for_spares2() {
        List<Integer> games = Arrays.asList(5, 5, 4, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        bowling.playGame(games);;
        assertEquals(26, bowling.scoreGame(games));
    }

    @Test
    void should_add_bonus_score_for_final_spare() {
        List<Integer> games = Arrays.asList(5, 5, 4, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5);
        bowling.playGame(games);
        assertEquals(41, bowling.scoreGame(games));
    }

    @Test
    void should_return_score150_for_all_spares() {
        List<Integer> games = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        bowling.playGame(games);
        assertEquals(150, bowling.scoreGame(games));
    }

    @Test
    void should_return_300_for_all_strikes() {
        List<Integer> games = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        bowling.playGame(games);
        assertEquals(300, bowling.scoreGame(games));
    }

    @Test
    void should_return_90_for_10_pairs_9_followed_by_a_miss() {
        List<Integer> games = Arrays.asList(9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0);
        bowling.playGame(games);
        assertEquals(90, bowling.scoreGame(games));
    }

    @Test
    void should_return_200_for_strikes_followed_by_spares() {
        List<Integer> games = Arrays.asList(10, 5, 5, 10, 5, 5, 10, 5, 5, 10, 5, 5, 10, 5, 5, 10);
        bowling.playGame(games);
        assertEquals(200, bowling.scoreGame(games));
    }
}
