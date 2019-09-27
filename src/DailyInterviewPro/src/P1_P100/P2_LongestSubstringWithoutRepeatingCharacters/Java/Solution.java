package DailyInterviewPro.src.P1_P100.P2_LongestSubstringWithoutRepeatingCharacters.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String str = "abrkaabcdefghijjxxx";
        System.out.print(findLength(str));
    }

    public static int findLength(String str) {
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so
            // that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its
                // previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll
                // keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }

            charIndexMap.put(str.charAt(windowEnd), windowEnd); // insert the 'rightChar' into the
                                                                // map
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1); // remember the maximum
                                                                            // length so far
        }
        return maxLength;
    }
}
