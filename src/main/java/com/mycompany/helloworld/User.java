package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sifis
 */
public class User {

    //Declares variable name.            
    private String name;

    //Declares variable username.
    private String username;

    //Empty constructor.
    public User() {
    }

    //Initialization with arguments.
    public User(String name, String username) {
    }

    //Set the value in variable.
    public void setName(String name) {
        this.name = name;
    }

    //Set the value in variable.
    public void setUsername(String username) {
        this.username = username;
    }

    //Get the value of variable. 
    public String getName() {
        return name;
    }

    //Get the value of variable. 
    public String getUsername() {
        return username;
    }

    //Convert the object to string.
    @Override
    public String toString() {
        return "(Name):" + this.name + " " + "(Username):" + this.username;
    }
}
