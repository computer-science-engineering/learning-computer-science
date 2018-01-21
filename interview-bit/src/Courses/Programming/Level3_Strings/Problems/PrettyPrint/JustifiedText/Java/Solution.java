package Courses.Programming.Level3_Strings.Problems.PrettyPrint.JustifiedText.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] input = {"What", "must", "be", "shall", "be."};
        String[] result = fullJustify(input, 12);
        for (String var : result) {
            System.out.println(var);
        }
    }
    
    public static String[] fullJustify(String[] A, int B) {
        List<String> res = new ArrayList<String>();
        int i = 0, N = A.length;
        while (i < N) {
            int length = A[i].length();
            int j = i + 1;
            while (j < N && length + A[j].length() + (j-i) <= B) {
                length += A[j++].length();
            }
            StringBuilder s = new StringBuilder(A[i]);
            boolean isLastLine = (j==N);
            boolean oneWord = (j == i + 1);
            int average = (isLastLine || oneWord) ? 1 : (B-length)/(j-i-1);
            int extra = (isLastLine || oneWord) ? 0 : (B-length)%(j-i-1);
            for (int k = i + 1; k < j; ++k) {
                char[] tmp = new char[extra>0?average+1:average];
                Arrays.fill(tmp, ' ');
                s.append(tmp);
                s.append(A[k]);
                extra--;
            }
            char[] tmp = new char[B - s.length()];
            Arrays.fill(tmp, ' ');
            s.append(tmp);
            res.add(s.toString());
            i = j;
        }
        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> res = new ArrayList<String>();
        int i = 0, N = a.size();
        while (i < N) {
            int length = a.get(i).length();
            int j = i + 1;
            while (j < N && length + a.get(j).length() + (j-i) <= b) {
                length += a.get(j++).length();
            }
            StringBuilder s = new StringBuilder(a.get(i));
            boolean isLastLine = (j==N);
            boolean oneWord = (j == i + 1);
            int average = (isLastLine || oneWord) ? 1 : (b-length)/(j-i-1);
            int extra = (isLastLine || oneWord) ? 0 : (b-length)%(j-i-1);
            for (int k = i + 1; k < j; ++k) {
                char[] tmp = new char[extra>0?average+1:average];
                Arrays.fill(tmp, ' ');
                s.append(tmp);
                s.append(a.get(k));
                extra--;
            }
            char[] tmp = new char[b - s.length()];
            Arrays.fill(tmp, ' ');
            s.append(tmp);
            res.add(s.toString());
            i = j;
        }
        return res;
    }
}