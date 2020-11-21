package com.shaunthomas999.topcoder;

/**
 * Created by shaunthomas on 12/01/17.
 */
public class ABBADiv1 {

    public static void main(String args[]) {
        ABBADiv1 abba = new ABBADiv1();

        System.out.println(abba.canObtain("BAAAAABAA", "BAABAAAAAB"));
        System.out.println(abba.canObtain("A", "ABBA"));
        System.out.println(abba.canObtain("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
        System.out.println(abba.canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
    }

    public String canObtain(String initial, String target) {
        if(initial.equals(target)) {
            return "Possible";
        }

        int numOfCharToInsert = target.length() - initial.length();
        int numOfCharA_initial = countCharacter(initial, 'A');
        int numOfCharB_initial = countCharacter(initial, 'B');
        int numOfCharA_target = countCharacter(target, 'A');
        int numOfCharB_target = countCharacter(target, 'B');

        if(numOfCharToInsert <= 0) {
            return "Impossible";
        }
        else if((numOfCharA_target > numOfCharA_initial + numOfCharToInsert)
            || (numOfCharB_target > numOfCharB_initial + numOfCharToInsert)) {
            // target requires more characters that it is possible to put
            return "Impossible";
        }
        else {
            int numOfCharAtoPut = numOfCharA_target - numOfCharA_initial;
            int numOfCharBtoPut = numOfCharB_target - numOfCharB_initial;
            String intermediate = initial;
            for(int i = 0 ; i < numOfCharToInsert ; i++) {
                // First try appending A
                if(numOfCharAtoPut > 0) {
                    String aAppended = intermediate + "A";
                    if((numOfCharBtoPut % 2 == 0) ? target.contains(aAppended) : target.contains(reverse(aAppended))) {
                        intermediate = aAppended;
                        numOfCharAtoPut--;
                        continue;
                    }
                }

                // Then try appending B
                if(numOfCharBtoPut > 0) {
                    String bAppended = reverse(intermediate + "B");
                    if((numOfCharBtoPut % 2 == 0) ? target.contains(reverse(bAppended)) : target.contains(bAppended)) {
                        intermediate = bAppended;
                        numOfCharBtoPut--;
                        continue;
                    }
                }

                // Appending of both A and B didn't work out
                return "Impossible";
            }

            if(intermediate.equals(target)) {
                return "Possible";
            }
            else {
                return "Impossible";
            }
        }

    }

    public int countCharacter(String word, Character character) {
        int counter = 0;
        for(int i = 0 ; i < word.length() ; i++) {
            if(word.charAt(i) == character) {
                counter++;
            }
        }
        return counter;
    }

    public String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
