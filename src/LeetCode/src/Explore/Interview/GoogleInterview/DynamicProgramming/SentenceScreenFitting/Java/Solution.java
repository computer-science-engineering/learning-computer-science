package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.SentenceScreenFitting.Java;

public class Solution {
    public static void main(String[] args) {
        String[] sentence = {"a", "bcd", "e"};
        int rows = 3, cols = 6;
        System.out.println(wordsTyping(sentence, rows, cols));
        System.out.println(wordsTyping_opt(sentence, rows, cols));
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

    public static int wordsTyping_opt(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }
}