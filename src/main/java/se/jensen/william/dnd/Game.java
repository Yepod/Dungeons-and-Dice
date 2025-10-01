package se.jensen.william.dnd;

import javax.swing.JOptionPane;

public class Game {
    public void start() {

        // Creates player models
        Player player1 = new Player("", "", 24, 0);
        Player player2 = new Player("", "", 24, 0);

        boolean validNamePlayer1 = false;
        boolean validNamePlayer2 = false;

        // Introduction to the game and setting up player profiles
        JOptionPane.showMessageDialog(null, "Welcome to Dungeons and Dice");
        while (!validNamePlayer1) {
            try {
                player1.setFirstName(JOptionPane.showInputDialog(null, "Enter your first name: "));
                player1.setLastName(JOptionPane.showInputDialog(null, "Now enter your last name: "));
                JOptionPane.showMessageDialog(null, "Welcome " + player1.getFullName() + "!");
                validNamePlayer1 = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Must enter your name, start over!");
            }
        }

        JOptionPane.showMessageDialog(null, "Who's your opponent?");
        while (!validNamePlayer2) {
            try {
                player2.setFirstName(JOptionPane.showInputDialog(null, "Enter first name: "));
                player2.setLastName(JOptionPane.showInputDialog(null, "Last name: "));
                JOptionPane.showMessageDialog(null, "Welcome " + player2.getFullName() + "!");
                validNamePlayer2 = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Must enter your name, start over!");
            }
        }

        // RULES in TextBlock
        JOptionPane.showMessageDialog(null,
                """
                                                        RULES
                        * Two player throws 2 dice to damage the opponent
                        
                        * Combined dice numbers = DMG
                        
                        * Player with most damage hurts his opponent
                        
                        * Each Player has 24HP, defeated when HP = 0
                        
                        * If both dice hit '6' this equals in a CRIT causing 2x DMG
                        
                        * Last Player standing wins!""");

        // Battle starts
        Dice dice = new Dice();

        while (true) {

            String choice = JOptionPane.showInputDialog(null, "Type 'Play' to play game." +
                    "\nType 'Exit' to exit game.");

            if (choice.equalsIgnoreCase("play")) {
                player1.setHp(24);
                player2.setHp(24);
            } else if (choice.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            while (player1.getHp() > 0 && player2.getHp() > 0) {
                JOptionPane.showMessageDialog(null, player1.getFirstName() + " Your turn! Throw your dice!");
                int roll1 = dice.roll();
                JOptionPane.showMessageDialog(null, "You threw a: " + roll1 + "\nThrow again!");
                int roll2 = dice.roll();
                JOptionPane.showMessageDialog(null, "You threw a: " + roll2);
                JOptionPane.showMessageDialog(null, "Combined damage: " + dice.addToDmg(roll1, roll2));
                player1.setDmg(dice.addToDmg(roll1, roll2));

                JOptionPane.showMessageDialog(null, player2.getFirstName() + " Your turn! Throw your dice!");
                roll1 = dice.roll();
                JOptionPane.showMessageDialog(null, "You threw a: " + roll1 + "\nThrow again!");
                roll2 = dice.roll();
                JOptionPane.showMessageDialog(null, "You threw a: " + roll2);
                JOptionPane.showMessageDialog(null, "Combined damage: " + dice.addToDmg(roll1, roll2));
                player2.setDmg(dice.addToDmg(roll1, roll2));

                if (player1.getDmg() > player2.getDmg()) {
                    JOptionPane.showMessageDialog(null, player1.getFirstName() + " Damage: " + player1.getDmg()
                            + " - " + player2.getFirstName() + " Damage: " + player2.getDmg()
                            + "\n" + player1.getFirstName() + " Wins this round!");

                    player2.setHp(player2.getHp() - player1.getDmg());
                    JOptionPane.showMessageDialog(null, player2.getFirstName() + " HP: " + player2.getHp());
                } else if (player2.getDmg() > player1.getDmg()) {
                    JOptionPane.showMessageDialog(null, player1.getFirstName() + " Damage: " + player1.getDmg()
                            + " - " + player2.getFirstName() + " Damage: " + player2.getDmg()
                            + "\n" + player2.getFirstName() + " Wins this round!");

                    player1.setHp(player1.getHp() - player2.getDmg());
                    JOptionPane.showMessageDialog(null, player1.getFirstName() + " HP: " + player1.getHp());
                } else {
                    JOptionPane.showMessageDialog(null, player1.getFirstName() + " Damage: " + player1.getDmg()
                            + " - " + player2.getFirstName() + " Damage: " + player2.getDmg()
                            + "\nIt's a tie! No damage delivered!");
                }
            }

            if (player1.getHp() == 0) {
                JOptionPane.showMessageDialog(null, player2.getFullName() + " Wins!");
                JOptionPane.showMessageDialog(null, "Game Over!");
            } else if (player2.getHp() == 0) {
                JOptionPane.showMessageDialog(null, player1.getFullName() + " Wins!");
                JOptionPane.showMessageDialog(null, "Game Over!");
            }
        }
    }
}
