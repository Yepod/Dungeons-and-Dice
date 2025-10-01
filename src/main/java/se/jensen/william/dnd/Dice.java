package se.jensen.william.dnd;

import java.util.Random;

public class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(1, 7);
    }

    // Total damage + Crit Function
    public int addToDmg(int roll1, int roll2){
        if (roll1 == 6 && roll2 == 6)
            return 24;

        return roll1 + roll2;
    }
}
