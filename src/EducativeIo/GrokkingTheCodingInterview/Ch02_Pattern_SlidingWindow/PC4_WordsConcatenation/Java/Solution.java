package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.PC4_WordsConcatenation.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catfoxcat", new String[] {"cat", "fox"});
        System.out.println(result);
        result = findWordConcatenation("catcatfoxfox", new String[] {"cat", "fox"});
        System.out.println(result);
    }


    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        return resultIndices;
    }
}
