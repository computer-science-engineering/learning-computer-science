package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P6_LongestSubstringWithSameLettersAfterReplacement.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));  
    }

    public static int findLength(String str, int k) {
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;
        int maxRepeatLetterCount = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter 
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}