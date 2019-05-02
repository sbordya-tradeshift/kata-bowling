package io.github.adrianulbona.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

    int score;
    List<Integer> games = new ArrayList<>();

    public Bowling(int score) {
        this.score = score;
    }

    public int scoreGame(List<Integer> rolls) {
        int roll = 0;
        for (int frame = 0; frame < 10; frame++) {

            if (isStrike(rolls, roll)) {
                score += 10 + rolls.get(roll + 1) + rolls.get(roll + 2);
                roll++;
            }
            else if (isSpare(rolls, roll)) {
                score += 10 + rolls.get(roll + 2);
                roll+=2;
            } else if (isStrike(rolls, roll)) {
                score += 10 + rolls.get(roll + 1) + rolls.get(roll + 2);
                roll++;
            } else {
                score += rolls.get(roll) + rolls.get(roll + 1);
                roll+=2;

            }
        }
        return score;
    }

    private boolean isSpare(List<Integer> rolls, int roll) {
        return rolls.get(roll) + rolls.get(roll + 1) == 10;
    }

    private boolean isStrike(List<Integer> rolls, int roll) {
        return rolls.get(roll) == 10;
    }

    public void playGame(List<Integer> trials) {
        this.games = trials;
    }
}
