package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author sifis Contains a list of civilizations and returns a random
 * civilization.
 */
public class AgeofEmpires {

    /**
     * Declare a list of civilizations.
     */
    private ArrayList<String> civilizations;

    /**
     * Add all the civilizations in the list.
     */
    public AgeofEmpires() {
        civilizations = new ArrayList<String>();
        civilizations.add("Aztecs");
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
        civilizations.add("Huns");
        civilizations.add("Koreans");
        civilizations.add("Mayans");
        civilizations.add("Spanish");
    }

    /**
     * Randomize the list of civilizations.
     *
     * @return random civilization
     */
    public String getRandomCivilization() {

        // Get a random number to use to get a random civilization.
        Random random = new Random();
        int temp = random.nextInt(civilizations.size());

        // Return a random civilization.
        return civilizations.get(temp);
    }

    /**
     *
     * @param allowduplicates set true in case you allow duplicates. False in
     * case you deny duplicates.
     * @return
     */
    public String getRandomCivilization(boolean allowduplicates) {
        Random random = new Random();
        int temp = random.nextInt(civilizations.size());
        String civil = civilizations.get(temp);
        if (!allowduplicates) {
            civilizations.remove(temp);
        }
        return civil;
    }
}
////////////////////////////////////////////////////////
//    public static void match() {
//        ArrayList<String> fix = sifis();
//       
//        for (String x : userlist) {
//            
//            System.out.println(x + ":" + fix.get(temp));
//        }
//    }
//
// 
//for (int i = 0; i < consoleUI.getUsernames().size(); i++){
//            String username = consoleUI.getUsernames().get(i);
//            
//            AgeofEmpires ageofEmpires = new AgeofEmpires();
//            String randomCivilization = ageofEmpires.getRandomCivilization();
//            System.out.println(username + ":" + randomCivilization);
//        }

