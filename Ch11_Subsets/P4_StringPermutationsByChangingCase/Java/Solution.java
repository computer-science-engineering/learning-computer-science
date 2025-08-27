package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P4_StringPermutationsByChangingCase.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }

        permutations.add(str);
        // process every character of the string one by one
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) { // only process characters, skip digits
                // we will take all existing permutations and change the letter case appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    // if the current character is in upper case change it to lower case or vice
                    // versa
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}
