package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sifis
 */
public class AgeofEmpires {

    private static ArrayList<String> userlist = new ArrayList<String>();

    public static ArrayList<String> sifis() {
        ArrayList<String> civilizations = new ArrayList<String>();
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
        return civilizations;
    }

    public static void userinput() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (!name.equals("0")) {
            System.out.print("\t\t\tenter your username or press <<0>>\n\t\t\t=>");
            name = scanner.nextLine().trim();
            if (!name.equals("0")) {
                userlist.add(name);
            }
        }
    }

    public static void match() {
        ArrayList<String> fix = sifis();
        Random random = new Random();
        for (String x : userlist) {
            int temp = random.nextInt(fix.size());
            System.out.println(x + ":" + fix.get(temp));
        }
    }

    public static void main(String[] args) {
        userinput();
        match();
//        sifis();
//        test();
    }
}

////    public static void test() {
//    Test test = new Test();
//    Test a;
//    int testX = test.x;
//    test.x  = 5;
//
//    a  = test;
//    a.x  = 9;
//
//    System.out.print (test.x);
//
//    // textX = 0
//    // test = a = 123123
//    // a.x = text.x = 9
//    test1(testX, a);
//
//    System.out.print (
//            
//
//"test.x:" + test.x + ", testX:" + testX);
//    }
//
////    public static void test1(int y, Test test) {
//    y  = 7;
//    test.x  = 19;
//}
