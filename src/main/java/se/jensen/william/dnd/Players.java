package se.jensen.william.dnd;

import javax.swing.*;

public class Players {

    static class Player {
        private String firstName;
        private String lastName;
        private int hp;
        private int dmg;

        public Player(String firstName, String lastName, int hp, int dmg) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dmg = dmg;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getHp() {
            if (hp <= 0) {
                JOptionPane.showMessageDialog(null,"You are DEAD! Game over!");
            }
                return hp;
        }

        public int getDmg() {
            return dmg;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public void setFirstName(String firstName) throws IllegalArgumentException {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("firstName cannot be empty");
            } else {
                this.firstName = firstName;
            }
        }

        public void setLastName(String lastName) throws IllegalArgumentException {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("lastName cannot be empty");
            } else {
                this.lastName = lastName;
            }
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setDmg(int dmg) {
            this.dmg = dmg;
        }
    }
}
