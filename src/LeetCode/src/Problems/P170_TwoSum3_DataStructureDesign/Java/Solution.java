package LeetCode.src.Problems.P170_TwoSum3_DataStructureDesign.Java;

public class Solution {
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(1);
        obj.add(3);
        obj.add(5);
        System.out.println(obj.find(4));
        System.out.println(obj.find(7));
    }

    public static boolean find(int[] nums, int value) {
        TwoSum obj = new TwoSum();
        for (int num : nums) {
            obj.add(num);
        }

        return obj.find(value);
    }
}