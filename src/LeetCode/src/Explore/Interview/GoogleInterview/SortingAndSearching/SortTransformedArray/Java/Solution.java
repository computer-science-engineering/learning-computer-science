package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.SortTransformedArray.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-4,-2,2,4};
        int a = 1, b = 3, c = 5;
        int[] result = sortTransformedArray(nums, a, b, c);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }
    
    private static int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}