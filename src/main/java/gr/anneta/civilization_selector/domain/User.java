package gr.anneta.civilization_selector.domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sifis
 */
public class User {

    private String name;

    private String username;

    public User() {
    }

    public User(String name, String username) {
    }

    public void setName(String name) {

        // Set the value in variable.
        this.name = name;
    }

    public void setUsername(String username) {

        // Set the value in variable.
        this.username = username;
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
}
