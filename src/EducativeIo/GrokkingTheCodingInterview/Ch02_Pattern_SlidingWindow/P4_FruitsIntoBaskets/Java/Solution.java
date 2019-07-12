package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P4_FruitsIntoBaskets.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));  
    }

    public static int findLength(char[] arr) {
        int maxFruits = Integer.MIN_VALUE;
        int windowStart = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char currentChar = arr[windowEnd];
            fruitFrequencyMap.put(currentChar, fruitFrequencyMap.getOrDefault(currentChar, 0) + 1);

            if (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }
        return maxFruits;
    }
}