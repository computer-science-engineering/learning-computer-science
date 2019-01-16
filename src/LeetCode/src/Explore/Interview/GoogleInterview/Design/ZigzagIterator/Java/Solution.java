package LeetCode.src.Explore.Interview.GoogleInterview.Design.ZigzagIterator.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1,2);
        List<Integer> v2 = Arrays.asList(3,4,5,6);
        ZigzagIterator i = new ZigzagIterator(v1, v2);
        List<Integer> v = new ArrayList<Integer>();
        while (i.hasNext()) v.add(i.next());
        System.out.println(v);
    }
}