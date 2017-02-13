package com.mycompany.helloworld;

/**
 *
 * @author syggouroglou@gmail.com
 */
public class StartUp {

    public static void main(String[] args) {
        AgeofEmpires ageofEmpires = new AgeofEmpires();
        while (true) {
            String randomCivilization = ageofEmpires.getRandomCivilization();
            System.out.println(randomCivilization);
        }
    }

}
