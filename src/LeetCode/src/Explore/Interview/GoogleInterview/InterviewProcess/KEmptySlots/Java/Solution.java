package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.KEmptySlots.Java;

import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[] flowers = {1,3,2};
        int k = 1;
        System.out.println(kEmptySlots(flowers, k));
    }

    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet<Integer>();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower);
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }
}