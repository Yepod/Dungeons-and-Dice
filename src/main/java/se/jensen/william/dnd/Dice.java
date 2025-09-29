package se.jensen.william.dnd;

import java.util.Random;

public class Dice {
    private int diceRoll;

    public Dice() {
        roll();
    }

    public int roll() {
        Random random = new Random();
        this.diceRoll = random.nextInt(1, 7);
        return diceRoll;
    }

    public int getDiceRoll(){
        return diceRoll;
    }

    public int addToDmg(int roll1, int roll2){
        if (roll1 == 6 && roll2 == 6)
            return 24;

        return roll1 + roll2;
    }
}
