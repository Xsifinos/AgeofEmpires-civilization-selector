package com.mycompany.helloworld;

/**
 * @author sifis
 * Contains the main method. 
 */
public class StartUp {

    /**
     * Requests from the user to enter a username until breaks with "0".
     * Corresponds each username to a random civilization.
     * @param args 
     */
    public static void main(String[] args) {
        // Requests from the user a username.
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.showUI();
        
        // Corresponds each username of the list of usernames
        // to a random civilization.
        for (String username : consoleUI.getUsernames()) {
            AgeofEmpires ageofEmpires = new AgeofEmpires();
            String randomCivilization = ageofEmpires.getRandomCivilization();
            System.out.println(username + ":" + randomCivilization);
        }
    }
}
