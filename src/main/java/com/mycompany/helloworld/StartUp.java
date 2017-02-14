package com.mycompany.helloworld;

/**
 *
 * @author syggouroglou@gmail.com
 */
public class StartUp {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.showUI();
        for (String username : consoleUI.getUsernames()) {
            AgeofEmpires ageofEmpires = new AgeofEmpires();
            String randomCivilization = ageofEmpires.getRandomCivilization();
            System.out.println(username + ":" + randomCivilization);
        }
    }
}
