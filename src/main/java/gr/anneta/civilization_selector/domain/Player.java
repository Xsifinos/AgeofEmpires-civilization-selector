package gr.anneta.civilization_selector.domain;

import java.util.Objects;

/**
 *
 * @author sifis
 */
public class Player {

//    private final String firstName="";
    private String name;

    private String username;

    public Player() {
        this.name = name;
        this.username = username;
    }

    public Player(String name, String username) {
        this.name = name;
        this.username = username;
    }

//    public void getFirstName(final String firstName) {
//        firstName = "John";
//    }
//    public void getLastName() {
//        final String lastName;
//        lastName = null;
//    }
    public void setName(String name) {

        if (name != null) {
            // Set the value in variable.
            this.name = name;    
        }
    }

    public void setUsername(String username) {

        if (username != null) {
            // Set the value in variable.
            this.username = username;  
        }
    }

    public String getName() {

        // Get the value of variable. 
        return name;
    }

    public String getUsername() {

        // Get the value of variable. 
        return username;
    }

    @Override
    public String toString() {

        // Convert the user object to string name and username.
        return "(Name):" + this.name + " " + "(Username):" + this.username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Player)) {
            return false;
        }

        Player playerToCheck = (Player) obj;
        if (this.username.equals(playerToCheck.getUsername())) {
            return true;
        }

        return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(this.username);
//    }
}
