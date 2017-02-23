package gr.anneta.civilization_selector;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.service.UserService;
import gr.anneta.civilization_selector.domain.User;
import gr.anneta.civilization_selector.service.CivilizationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Makes a request for username until breaks with "0".Then creates a list of
 * usernames.
 *
 * @author sifis
 */
public class ConsoleUI {

    /**
     * Declares a list of usernames.
     */
    private UserService userservice;

    private CivilizationService civilizationservice;

    // Declares boolean variable.
    private Boolean allowduplicatebool;

    /**
     * Initialize the boolean variable.
     */
    public ConsoleUI() {
        this.userservice = new UserService();
        this.civilizationservice = new CivilizationService();
        this.allowduplicatebool = true;
    }

    public void menuUI() {

        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("5")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Allow duplicate(default true).             ###");
            System.out.println("# 2.#    Management of the users.                   ###");
            System.out.println("# 3.#    Management of the civilizations.           ###");
            System.out.println("# 4.#    Show list of usernames with civilizations. ###");
            System.out.println("# 5.#    Exit.                                      ###");
            System.out.println("#######################################################");

            name = scanner.nextLine().trim();

            // Choices of the user.
            switch (name) {
                case "1":
                    // Allow duplication or not.
                    allowDuplicateUI();
                    break;

                case "2":
                    // Access to the management of users menu.
                    menuUserUI();
                    break;

                case "3":
                    // Access to the management of civilizations menu.
                    menuCivilUI();
                    break;

                case "4":
                    // Show the list of usernames with civilizations.
                    showUsernameWithCivilization();
                    break;
            }
        }
    }

    private void allowDuplicateUI() {
        // Get the user input to allow duplicate or not.
        Scanner scanner = new Scanner(System.in);
        String allowduplicate = "";
        System.out.println("Do you want to exist civilizations in duplicate?Yes=1 No=0");
        allowduplicate = scanner.nextLine();
        if (allowduplicate.equals("1")) {
            allowduplicatebool = true;
        } else if (allowduplicate.equals("0")) {
            allowduplicatebool = false;
        }
    }

    public Boolean getAllowduplicatebool() {
        // Boolean variable for duplicate or not.
        return allowduplicatebool;
    }

    private void showUsernameWithCivilization() {
        // Print message when userslist is empty.
        if (userservice.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        AgeofEmpires ageofEmpires = new AgeofEmpires();
        // Correspond each user of the list of users
        // to a random civilization and print it.
        for (User user : userservice.find()) {
            String randomCivilization = ageofEmpires.getRandomCivilization(allowduplicatebool);
            System.out.println(user + ":" + randomCivilization);
        }
    }

    public void menuUserUI() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals("4")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######      (Management of the users.)      ##########");
            System.out.println("#######################################################");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Create player.                             ###");
            System.out.println("# 2.#    Delete player.                             ###");
            System.out.println("# 3.#    Show list of players.                      ###");
            System.out.println("# 4.#    Return to the previous menu.               ###");
            System.out.println("#######################################################");
            name = scanner.nextLine().trim();
            switch (name) {
                // Choices of the user.
                case "1":
                    // Create users and add them to the list of users.
                    createUser();
                    break;
                case "2":
                    // Find the user and delete it.
                    deleteUser();
                    break;
                case "3":
                    // Show the list of players with names and usernames.
                    showListofPlayers();
                    break;
            }
        }
    }

    public void createUser() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);

        // Get the user input to set the values.
        System.out.print("\t\t\tenter your name\n\t\t\t=>");
        String name = scanner.nextLine().trim();
        System.out.print("\t\t\tenter your username\n\t\t\t=>");
        String username = scanner.nextLine().trim();

        // Set the name and the username.
        User user = new User();
        user.setName(name);
        user.setUsername(username);

        // Create a user.
        userservice.create(user);
    }

    public void deleteUser() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\tenter name you want to delete\n\t\t\t=>");
        String name = scanner.nextLine().trim();
//        User user = userservice.delete(name);
//        if (user == null) {
        if (!userservice.delete(name)) {
            System.out.println("O xristis den vrethike.");
        }
    }

    private void showListofPlayers() {

        // Print message when userslist is empty.
        if (userservice.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        // Show the list of the users.
        for (User user : userservice.find()) {
            System.out.println(user);
        }
    }

    public void menuCivilUI() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals("4")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######  (Management of the civilizations.)  ##########");
            System.out.println("#######################################################");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Create civilization.                       ###");
            System.out.println("# 2.#    Delete civilization.                       ###");
            System.out.println("# 3.#    Show list of civilizations.                ###");
            System.out.println("# 4.#    Return to the previous menu.               ###");
            System.out.println("#######################################################");
            name = scanner.nextLine().trim();
            switch (name) {
                // Choices of the user.
                case "1":
                    // Create users and add them to the list of users.
                    createCivil();
                    break;
                case "2":
                    // Find the user and delete it.
                    deleteCivil();
                    break;
                case "3":
                    // Show the list of players with names and usernames.
                    showListofCivilizations();
                    break;
            }
        }
    }

    public void createCivil() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);

        // Get the user input to set the values.
        System.out.print("\t\t\tenter the title of the civilization\n\t\t\t=>");
        String title = scanner.nextLine().trim();

        // Set the title.
        Civilization civilization = new Civilization();
        civilization.setTitle(title);

        // Create a civilization.
        civilizationservice.create(civilization);
    }

    public void deleteCivil() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\tEnter the title of the civilization you want to delete.\n\t\t\t=>");
        String title = scanner.nextLine().trim();

        if (!civilizationservice.delete(title)) {
            System.out.println("O laos den vrethike.");
        }
    }

    private void showListofCivilizations() {

        // Print message when userslist is empty.
        if (civilizationservice.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        // Show the list of the civilizations.
        for (Civilization civilization : civilizationservice.find()) {
            System.out.println(civilization);
        }
    }
}

//    public static boolean stringtobool(String allowduplicate) {
//    Allow duplicate or not.
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you want to exist civilizations in duplicate?Yes=1 No=0");
//        allowduplicate = scanner.nextLine();
//        if (allowduplicate.equals("1")) {
//            return true;
//        } else if (allowduplicate.equals("0")) {
//            return false;
//        }
//    }

