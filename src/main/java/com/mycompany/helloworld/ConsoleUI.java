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
        this.usernames = new ArrayList<String>();
        this.allowduplicatebool = true;
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
        String allowduplicate = "";

        //Get the user input to allow duplicate or not. 
        System.out.println("Do you want to exist civilizations in duplicate?Yes=1 No=0");
        allowduplicate = scanner.nextLine();
        if (allowduplicate.equals("1")) {
            allowduplicatebool = true;
        } else if (allowduplicate.equals("0")) {
            allowduplicatebool = false;
        }

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

    /**
     * Returns list of usernames.
     *
     * @return List of usernames.
     */
    public ArrayList<String> getUsernames() {
        return usernames;
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

