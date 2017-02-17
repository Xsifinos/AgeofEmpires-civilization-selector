/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private ArrayList<String> usernames;

    //Declares boolean variable.
    private Boolean allowduplicatebool;

    /**
     * Initialize the list of usernames.
     */
    public ConsoleUI() {
        this.usernames = new ArrayList<>();
        this.allowduplicatebool = true;
    }

    public void menuUI() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("4")) {
            System.out.println("#######################################################");
            System.out.println("####### AGE OF EMPIRES-CIVILIZATION-SELECTOR ##########");
            System.out.println("#######################################################");
            System.out.println("# 1.#    Allow duplicate(default true).             ###");
            System.out.println("# 2.#    Enter username.                            ###");
            System.out.println("# 3.#    Show list of usernames with civilizations. ###");
            System.out.println("# 4.#    Exit.                                      ###");
            System.out.println("#######################################################");

            name = scanner.nextLine().trim();
            if (name.equals("3")) {
                System.out.println("You have no entries!!!");
            } else {
                switch (name) {
                    case "1":
                        allowDuplicateUI();
                        break;

                    case "2":
                        showUI();
                        break;

                    case "3":
                        showUsernameWithCivilization();
                        break;
                }
            }
        }
    }

    /**
     * Requests for usernames until breaks with "0" and add the usernames into a
     * list.
     */
    //Declares boolean variable to use to duplicate or not.
    public void showUI() {
        // Scanner to use for getting the inputs from console.
        Scanner scanner = new Scanner(System.in);
        String name = "";

        while (!name.equals("0")) {
            // Get the user input each time is not pressed "0".  
            System.out.print("\t\t\tenter your username or press <<0>>\n\t\t\t=>");
            name = scanner.nextLine().trim();

            //Add each username into the list.
            if (!name.equals("0")) {
                usernames.add(name);
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
        AgeofEmpires ageofEmpires = new AgeofEmpires();
        // Corresponds each username of the list of usernames
        // to a random civilization.
        for (String username : usernames) {
            String randomCivilization = ageofEmpires.getRandomCivilization(allowduplicatebool);
            System.out.println(username + ":" + randomCivilization);
        }
    }

    public Boolean getAllowduplicatebool() {
        return allowduplicatebool;
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

