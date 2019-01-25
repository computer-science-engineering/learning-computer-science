package LeetCode.src.Problems.P201_P300.P242_ValidAnagram.Java;

public class Solution {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int length = s.length();
        if(length != t.length()) {
            return false;
        }
        char[] str_s = s.toCharArray();
        char[] str_t = t.toCharArray();
        int[] mask = new int[256];
        for(char c : str_s) {
            mask[c]++;
        }
        for(char c : str_t) {
            if(mask[c] > 0) {
                mask[c]--;
            } else {
                return false;
            }
        }
        return true;
    }
}