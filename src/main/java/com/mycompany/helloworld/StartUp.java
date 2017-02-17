package com.mycompany.helloworld;

/**
 * @author sifis Contains the main method.
 */
public class StartUp {

    /**
     * Requests from the user to enter a username until breaks with "0".
     * Corresponds each username to a random civilization.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Requests from the user a username.
        ConsoleUI consoleUI = new ConsoleUI();
//        String name = consoleUI.getName();
        consoleUI.menuUI();
//        Boolean allowduplicatebool = consoleUI.getAllowduplicatebool();
//        AgeofEmpires ageofEmpires = new AgeofEmpires();
//        // Corresponds each username of the list of usernames
//        // to a random civilization.
//            for (String username : consoleUI.getUsernames()) {
//                String randomCivilization = ageofEmpires.getRandomCivilization(allowduplicatebool);
//                System.out.println(username + ":" + randomCivilization);
//            }
        }
}
