package LeetCode.src.Problems.P201_P300.P217_ContainsDuplicate.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            }
            else {
                map.put(n, n);
            }
        }

        return false;
    }
}