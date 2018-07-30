package LeetCode.src.Problems.P201_P300.P244_ShortedWordDistance2.Java;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance obj = new WordDistance(words);
        String word1 = "coding";
        String word2 = "practice";
        int param_1 = obj.shortest(word1,word2);
        System.out.println(param_1);
    }
}