package LeetCode.src.Problems.P245_ShortestWordDistance3.Java;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        System.out.println(shortestWordDistance(words, word1, word2));
    }

    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
    
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }

            if (p1 != -1 && p2 != -1 && p1 != p2) {
                min = Math.min(min, Math.abs(p1 - p2));
            }

            if (words[i].equals(word2)) {
                p2 = i;
            }
                
            if (p1 != -1 && p2 != -1 && p1 != p2) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        
        return min;
    }
}