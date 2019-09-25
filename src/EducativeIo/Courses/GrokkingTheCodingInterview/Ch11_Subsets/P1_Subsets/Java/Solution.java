package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P1_Subsets.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> result = findSubsets(new int[] {1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = findSubsets(new int[] {1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new
            // subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
