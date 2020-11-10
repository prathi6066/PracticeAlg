package prathi.learn.practicealg.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

    /*

    Given a string, find all of its permutations preserving the character sequence but changing case.

    Input: "ad52"
    Output: "ad52", "Ad52", "aD52", "AD52"
     */

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i=0;i<str.length();i++) {
            if(Character.isLetter(str.charAt(i))) {
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    StringBuilder temp = new StringBuilder(permutations.get(j));
                    if (Character.isUpperCase(temp.charAt(i))) {
                        temp.setCharAt(i, Character.toLowerCase(temp.charAt(i)));
                    } else {
                        temp.setCharAt(i, Character.toUpperCase(temp.charAt(i)));
                    }
                    permutations.add(temp.toString());
                }
            }
        }


        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}


