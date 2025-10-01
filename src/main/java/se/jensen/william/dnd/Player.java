package se.jensen.william.dnd;

public class Player {
    private String firstName;
    private String lastName;
    private int hp;
    private int dmg;

        // Constructor
        public Player(String firstName, String lastName, int hp, int dmg) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.hp = hp;
            this.dmg = dmg;
        }

        // Get-Setters
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getHp() {
            return hp;
        }

        public int getDmg() {
            return dmg;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        // Failsafe in case of empty name input
        public void setFirstName(String firstName) throws IllegalArgumentException {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("Firstname cannot be empty");
            } else {
                this.firstName = firstName;
            }
        }

        public void setLastName(String lastName) throws IllegalArgumentException {
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Lastname cannot be empty");
            } else {
                this.lastName = lastName;
            }
        }

        // Ensures HP is no lower than 0
        public void setHp(int hp) {
            if (hp < 0) {
                hp = 0;
            }
            this.hp = hp;
        }

        public void setDmg(int dmg) {
            this.dmg = dmg;
        }
    }
