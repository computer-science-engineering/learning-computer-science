package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberTheory.SortedPermutationRankWithRepeats.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findRank("IhSKbdvuqfmGHh"));
    }
    
    public static int findRank(String A) {        
        long rank = 1;
        long suffixPermCount = 1;
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        for (int i = A.length() - 1; i >= 0; i--) {
            char x = A.charAt(i);
            int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
            charCounts.put(x, xCount);
            for (Map.Entry<Character, Integer> e : charCounts.entrySet()) {
                if (e.getKey() < x) {
                    rank += suffixPermCount * e.getValue() / xCount;
                }
            }
            suffixPermCount *= A.length() - i;
            suffixPermCount /= xCount;
        }
        return (int) (rank%1000003);
    }
}