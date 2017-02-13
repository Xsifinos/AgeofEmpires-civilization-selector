package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sifis
 */
public class AgeofEmpires {

    private ArrayList<String> civilizations;

    public AgeofEmpires() {
        civilizations = new ArrayList<String>();
        civilizations.add("Goths");
        civilizations.add("Briton");
        civilizations.add("Celts");
        civilizations.add("Franks");
        civilizations.add("Teutons");
        civilizations.add("Vikings");
        civilizations.add("Byzantines");
        civilizations.add("Persians");
        civilizations.add("Saracens");
        civilizations.add("Turks");
        civilizations.add("Chinese");
        civilizations.add("Japanese");
        civilizations.add("Mongols");
    }

    public String getRandomCivilization() {
        Random random = new Random();
        int temp = random.nextInt(civilizations.size());
        return civilizations.get(temp);
    }
//        return civilizations;
//    }
//
//    public static void userinput() {
//        Scanner scanner = new Scanner(System.in);
//        String name = "";
//        while (!name.equals("0")) {
//            System.out.print("\t\t\tenter your username or press <<0>>\n\t\t\t=>");
//            name = scanner.nextLine().trim();
//            if (!name.equals("0")) {
//                userlist.add(name);
//            }
//        }
//    }
//
//    public static void match() {
//        ArrayList<String> fix = sifis();
//       
//        for (String x : userlist) {
//            
//            System.out.println(x + ":" + fix.get(temp));
//        }
//    }
//
//    public static void main(String[] args) {
//        userinput();
//        match();
////        sifis();
////        test();
//    }
}
//    private static ArrayList<String> userlist = new ArrayList<String>();
