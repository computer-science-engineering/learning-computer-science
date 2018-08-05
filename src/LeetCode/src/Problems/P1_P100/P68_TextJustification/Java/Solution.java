package LeetCode.src.Problems.P1_P100.P68_TextJustification.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = fullJustify(words, maxWidth);
        System.out.println(result);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int i = 0, N = words.length;
        while (i < N) {
            int length = words[i].length();
            int j = i + 1;
            while (j < N && length + words[j].length() + (j-i) <= maxWidth) {
                length += words[j++].length();
            }
            StringBuilder s = new StringBuilder(words[i]);
            boolean isLastLine = (j==N);
            boolean oneWord = (j == i + 1);
            int average = (isLastLine || oneWord) ? 1 : (maxWidth-length)/(j-i-1);
            int extra = (isLastLine || oneWord) ? 0 : (maxWidth-length)%(j-i-1);
            for (int k = i + 1; k < j; ++k) {
                char[] tmp = new char[extra>0?average+1:average];
                Arrays.fill(tmp, ' ');
                s.append(tmp);
                s.append(words[k]);
                extra--;
            }
            char[] tmp = new char[maxWidth - s.length()];
            Arrays.fill(tmp, ' ');
            s.append(tmp);
            res.add(s.toString());
            i = j;
        }
        return res;
    }
}