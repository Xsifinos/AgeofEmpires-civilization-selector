/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author syggouroglou@gmail.com
 */
public class ConsoleUI {

    private ArrayList<String> usernames;

    public ConsoleUI() {
        usernames = new ArrayList<String>();
    }

    public void showUI() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("0")) {
            System.out.print("\t\t\tenter your username or press <<0>>\n\t\t\t=>");
            name = scanner.nextLine().trim();
            if (!name.equals("0")) {
                usernames.add(name);
            }
        }
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }
}
