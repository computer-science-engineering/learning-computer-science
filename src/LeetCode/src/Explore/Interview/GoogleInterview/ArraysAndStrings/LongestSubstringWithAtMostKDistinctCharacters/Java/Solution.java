package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.LongestSubstringWithAtMostKDistinctCharacters.Java;

public class Solution {
    public static void main(String[] args) {
        String s = "ababcbcbaaabbdef";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    /*public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k==0) {
            return 0;
        }
        HashMap<Character, Integer> tracking = new HashMap<Character, Integer>();
        int l=0, distinct=0, res=0;

        // l is the leftmost starting of substring, r is the rightmost
        for(int r=0; r<s.length(); r++) {
            if (tracking.containsKey(s.charAt(r))) { // Seen before. Increment count of the char.
                int soFarCount = tracking.get(s.charAt(r));
                tracking.put(s.charAt(r), soFarCount+1);
            } else { // have not seen before
                distinct++;
                tracking.put(s.charAt(r), 1);
            }

            // Sliding window
            // If there are more distinct char
            // Start removing from left until distinct Chars == k
            
            //while(distinct > k) {
            //    int temp = tracking.get(s.charAt(l));
            //    tracking.put(s.charAt(l++), temp--);

            //    if (temp == 0) {
            //        distinct--;
            //   }
            //}

            if(distinct > k) {
                int occurrences = Integer.MAX_VALUE;
                while(occurrences > 0) {
                    occurrences = tracking.get(s.charAt(l));
                    tracking.put(s.charAt(l++), occurrences--);
                }

                l++;

                distinct--; // At this point temp  will be 0
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }*/
}