package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.SentenceScreenFitting.Java;

public class Solution {
    public static void main(String[] args) {
        String[] sentence = {"a", "bcd", "e"};
        int rows = 3, cols = 6;
        System.out.println(wordsTyping(sentence, rows, cols));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / s.length();
    }
}