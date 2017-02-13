package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Random;

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
}
 
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

   
