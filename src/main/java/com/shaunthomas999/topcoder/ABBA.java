package com.shaunthomas999.topcoder;

/**
 * It is easier to check whether it is possible to make initial from target.
 * It avoids the unnecessary check to find whether an appending will help to make target or not.
 * Here last character of target is checked and then dropped.
 * If the last character is B then the remaining string is reversed after dropping for further comparison
 * @author Shaun Thomas
 */
public class ABBA {

    /**
     * Main method - Contains test methods
     * @param args
     */
    public static void main(String args[]) {

        System.out.println(ABBA.canObtain("AB", "ABB").equals("Impossible"));
        System.out.println(ABBA.canObtain("BBAB", "ABABABABB").equals("Impossible"));
        System.out.println(ABBA.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA").equals("Possible"));
        System.out.println(ABBA.canObtain("A", "BB").equals("Impossible"));
    }

    /**
     * Checks if it possible to make target and initial following rules of the game
     * @param initial Given initial string
     * @param target Target string to be made
     * @return Returns "Possible" or "Impossible" based on whether it is possible to make target from initial or not
     */
    public static String canObtain(String initial, String target){
        while(initial.length() < target.length()){
            // If the last element is B then the remaining part of String has to be reversed
            boolean doReverse = (target.endsWith("B")) ? true : false;
            target = target.substring(0, target.length()-1);
            if(doReverse) {
                target = new StringBuilder(target).reverse().toString();
            }
        }
        return (initial.compareTo(target)==0) ? "Possible" : "Impossible";
    }

}

