package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.MinimumWindowSubstring.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println(minWindow_opt(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }
        int left = 0, minLeft=0, minLen = s.length()+1, count = 0;
        for(int right = 0; right<s.length(); right++) {
            char r = s.charAt(right);
            if(map.containsKey(r)) {//the goal of this part is to get the first window that contains whole t
                map.put(r, map.get(r)-1);
                if(map.get(r)>=0) {
                    count++;//identify if the first window is found by counting frequency of the characters of t showing up in S
                }
            }
            while(count == t.length()) {//if the count is equal to the length of t, then we find such window
                if(right-left+1 < minLen) {//just update the minleft and minlen value
                    minLeft = left;
                    minLen = right-left+1;
                }
                char l = s.charAt(left);
                if(map.containsKey(l)) {//starting from the leftmost index of the window, we want to check if s[left] is in t. If so, we will remove it from the window, and increase 1 time on its counter in hashmap which means we will expect the same character later by shifting right index. At the same time, we need to reduce the size of the window due to the removal.
                    map.put(l, map.get(l)+1);
                    if(map.get(l)>0) count--;
                }
                left++;//if it doesn't exist in t, it is not supposed to be in the window, left++. If it does exist in t, the reason is stated as above. left++.
            }
        }
        return minLen == s.length()+1 ? "" : s.substring(minLeft, minLeft+minLen);
    }

    public static String minWindow_opt(String s, String t) {
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                if (hash[s.charAt(left++)]++ >= 0)
                    count++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}