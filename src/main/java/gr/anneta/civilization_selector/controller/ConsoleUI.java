package gr.anneta.civilization_selector.controller;

import gr.anneta.civilization_selector.domain.Civilization;
import gr.anneta.civilization_selector.service.PlayerService;
import gr.anneta.civilization_selector.domain.Player;
import gr.anneta.civilization_selector.lib.SifinosException;
import gr.anneta.civilization_selector.service.CivilizationService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sifis
 */
public class ConsoleUI {

    private PlayerService playerService;

    private CivilizationService civilizationService;

    // Declares boolean variable.
    private Boolean allowDuplicatebool;

    /**
     * Initialize the variables.
     */
    public ConsoleUI() {
        this.playerService = new PlayerService();
        this.civilizationService = new CivilizationService();
        this.allowDuplicatebool = true;
    }

    public void menuUI() throws IOException {

        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("5")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Allow duplicate(default true).             ###");
            System.out.println("# 2.#    Management of the players.                 ###");
            System.out.println("# 3.#    Management of the civilizations.           ###");
            System.out.println("# 4.#    Show list of usernames with civilizations. ###");
            System.out.println("# 5.#    Exit.                                      ###");
            System.out.println("#######################################################");

            name = scanner.nextLine().trim();

            // Choices of the player.
            switch (name) {
                case "1":
                    // Allow duplication or not.
                    allowDuplicateUI();
                    break;

                case "2":
                    // Access to the management of the players menu.
                    menuPlayerUI();
                    break;

                case "3":
                    // Access to the management of the civilizations menu.
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
            allowDuplicatebool = true;
        } else if (allowduplicate.equals("0")) {
            allowDuplicatebool = false;
        }
    }

    public Boolean getAllowduplicatebool() {
        // Boolean variable for duplicate or not.
        return allowDuplicatebool;
    }

    private void showUsernameWithCivilization() throws IOException {
        // Print message when playerlist or list of civilizations are empties.
        if (playerService.isEmpty() || civilizationService.isEmpty()) {
            System.out.println("You haven't entered usernames or civivilizations!!!");
            return;
        }
        // Correspond each player of the list of players
        // to a random civilization and print it.
        for (Player player : playerService.find()) {
            Civilization randomCivilization = civilizationService.getRandomCivilization(allowDuplicatebool);
            System.out.println(player + ":" + randomCivilization);
        }
    }

    public void menuPlayerUI() throws IOException {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals("4")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######      (Management of the players.)    ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Create player.                             ###");
            System.out.println("# 2.#    Delete player.                             ###");
            System.out.println("# 3.#    Show list of players.                      ###");
            System.out.println("# 4.#    Return to the previous menu.               ###");
            System.out.println("#######################################################");
            name = scanner.nextLine().trim();
            switch (name) {
                // Choices of the player.
                case "1":
                    // Create players and add them to the list of the players.
                    createPlayer();
                    break;
                case "2":
                    // Find the player and delete him.
                    deletePlayer();
                    break;
                case "3":
                    // Show the list of players with names and usernames.
                    showListPlayers();
                    break;
            }
        }
    }

    public void createPlayer() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);

        // Get the user input to set the values.
        System.out.print("\t\t\tenter your name\n\t\t\t=>");
        String name = scanner.nextLine();
        System.out.print("\t\t\tenter your username\n\t\t\t=>");
        String username = scanner.nextLine();

        // Set the name and the username.
        Player player = new Player();
        player.setName(name);
        player.setUsername(username);

        try {
            // Create a player.
            playerService.create(player);
        } catch (SifinosException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deletePlayer() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\tenter the username of the player you want to delete\n\t\t\t=>");
        String username = scanner.nextLine();
        try {
            playerService.delete(username);
        } catch (SifinosException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void showListPlayers() throws IOException {

        // Print message when playerslist is empty.
        if (playerService.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        // Show the list of the players.
        for (Player player : playerService.find()) {
            System.out.println(player);
        }
    }

    public void menuCivilUI() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals("5")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######  (Management of the civilizations.)  ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Create civilization.                       ###");
            System.out.println("# 2.#    Delete civilization.                       ###");
            System.out.println("# 3.#    Auto insertion of civilizations.           ###");
            System.out.println("# 4.#    Show list of civilizations.                ###");
            System.out.println("# 5.#    Return to the previous menu.               ###");
            System.out.println("#######################################################");
            name = scanner.nextLine().trim();
            switch (name) {
                // Choices of the player.
                case "1":
                    // Create civilizations and add them to the list of civilizations .
                    createCivil();
                    break;
                case "2":
                    // Find the civilization and delete it.
                    deleteCivil();
                    break;
                case "3":
                    // Insert automatical 18 civilizations.
                    autoInsertion();
                    break;
                case "4":
                    // Show the list of the civilizations.
                    showListCivilizations();
                    break;
            }
        }
    }

    public void createCivil() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);

        // Get the user input to set the values.
        System.out.print("\t\t\tenter the title of the civilization\n\t\t\t=>");
        String title = scanner.nextLine();

        // Set the title.
        Civilization civilization = new Civilization();
        civilization.setTitle(title);

        // Create a civilization.
        civilizationService.create(civilization);
    }

    public void deleteCivil() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\tEnter the title of the civilization you want to delete.\n\t\t\t=>");
        String title = scanner.nextLine();

        if (!civilizationService.delete(title)) {
            System.out.println("O laos den vrethike.");
        }
    }

    public void autoInsertion() {
        // Scanner to use for getting the inputs from console.
        civilizationService.createAllCivilizations();

        System.out.println("Oi laoi kataxwrhthikan.");
        return;
    }

    private void showListCivilizations() {

        // Print message when civilizations list is empty.
        if (civilizationService.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        // Show the list of the civilizations.
        for (Civilization civilization : civilizationService.find()) {
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

