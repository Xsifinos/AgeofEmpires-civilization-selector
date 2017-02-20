package com.mycompany.helloworld;

import java.util.ArrayList;
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
    private ArrayList<User> userslist;

    //Declares boolean variable.
    private Boolean allowduplicatebool;

    /**
     * Initialize the userslist and the boolean variable.
     */
    public ConsoleUI() {
        this.userslist = new ArrayList<User>();
        this.allowduplicatebool = true;
    }

    public void menuUI() {
        
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("4")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Allow duplicate(default true).             ###");
            System.out.println("# 2.#    Management of the users.                   ###");
            System.out.println("# 3.#    Show list of usernames with civilizations. ###");
            System.out.println("# 4.#    Exit.                                      ###");
            System.out.println("#######################################################");

            name = scanner.nextLine().trim();
            
            //Choices of the user.
            switch (name) {
                case "1":
                    //Allow duplication or not.
                    allowDuplicateUI();
                    break;

                case "2":
                    //Access to the management of users menu.
                    menu2UI();
                    break;

                case "3":
                    //Show the list of usernames with civilizations.
                    showUsernameWithCivilization();
                    break;
            }
        }
    }

    /**
     * Requests for usernames until breaks with "0" and add the usernames into a
     * list.
     */
    public void menu2UI() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String username = "";

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
                //Choices of the user.
                case "1":
                    //Create users and add them to the list of users.
                    createUser();
                    break;
                case "2":
                    //Find the user and delete it.
                    deleteUser();
                    break;
                case "3":
                    //Show the list of players with names and usernames.
                    showListofPlayers();
                    break;
            }
        }
    }

    private void allowDuplicateUI() {
        //Get the user input to allow duplicate or not.
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

    private void showUsernameWithCivilization() {
        //Print message when userslist is empty.
        if (this.userslist.isEmpty()) {
            System.out.println("You have no entries!!!");
            return;
        }
        AgeofEmpires ageofEmpires = new AgeofEmpires();
        // Correspond each user of the list of users
        // to a random civilization and print it.
        for (User user : userslist) {
            String randomCivilization = ageofEmpires.getRandomCivilization(allowduplicatebool);
            System.out.println(user + ":" + randomCivilization);
        }
    }

    public Boolean getAllowduplicatebool() {
        //Boolean variable for duplicate or not.
        return allowduplicatebool;
    }

    public void createUser() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String username = "";
        User user = new User();

        System.out.print("\t\t\tenter your name\n\t\t\t=>");
        name = scanner.nextLine().trim();
        System.out.print("\t\t\tenter your username\n\t\t\t=>");
        username = scanner.nextLine().trim();

        //Get the user input to set the values.
        user.setName(name);
        user.setUsername(username);
        //Add the user into the list.
        userslist.add(user);
    }

    public void deleteUser() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";
        System.out.print("\t\t\tenter name you want to delete\n\t\t\t=>");
        name = scanner.nextLine().trim();
        //Find the user and delete it from the list.
        for (User user : userslist) {
            if (name.equals(user.getName())) {
                userslist.remove(user);
                break;
            }
        }

    }

    private void showListofPlayers() {

        //Show the list of the users.
        for (User user : userslist) {
            System.out.println(user);
        }
    }
}

//////////////////////////////////////////////////////////////////////////
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

