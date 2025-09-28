package se.jensen.william.dnd;

public class Players {

    static class Player{
        private String firstName;
        private String lastName;
        private int dmg;

        public Player(String firstName, String lastName, int dmg){
            this.firstName = firstName;
            this.lastName = lastName;
            this.dmg = dmg;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getDmg() {
            return dmg;
        }

        public void setDmg(int dmg) {
            this.dmg = dmg;
        }

        public String getFullName(){
            return this.firstName + " " + this.lastName;
        }
    }
}
