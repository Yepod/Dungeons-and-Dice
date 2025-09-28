package se.jensen.william.dnd;

import javax.swing.*;

public class Intro {
    public static void GameIntro() {

        // Introduction to the game
        JOptionPane.showMessageDialog(null, "Welcome to Dungeons and Dice");
        String firstName1 = JOptionPane.showInputDialog(null, "Enter your first name: ");
        String lastName1 = JOptionPane.showInputDialog(null, "Now enter your last name: ");
        int dmg1 = 0;
        JOptionPane.showMessageDialog(null, "Welcome " + firstName1 + " " + lastName1 + "!");

        // Creates Player 1
        Players.Player player1 = new Players.Player(firstName1, lastName1, dmg1);
        String fullName1 = player1.getFullName();

        JOptionPane.showMessageDialog(null, "Who's your opponent?");
        String firstName2 = JOptionPane.showInputDialog(null, "Enter first name: ");
        String lastName2 = JOptionPane.showInputDialog(null, "Last name: ");
        int dmg2 = 0;
        JOptionPane.showMessageDialog(null, "Welcome " + firstName2 + " " + lastName2 + "!");

        // Creates Player 2
        Players.Player player2 = new Players.Player(firstName2, lastName2, dmg2);
        String fullName2 = player2.getFullName();

        JOptionPane.showMessageDialog(null, fullName1 + " vs " + fullName2 + "\n        Your battle awaits!");

        // RULES
        JOptionPane.showMessageDialog(null,
                "RULES\n" + "* Two player throws 2 dice to damage the opponent" +
                        "\n* Combined dice numbers = DMG" +
                        "\n* Each Player has 100HP, defeated when HP = 0" +
                        "\n* If both dice hit '6' this equals in a CRIT causing 2x DMG" +
                        "\n* Last Player standing wins!");

    }
}
