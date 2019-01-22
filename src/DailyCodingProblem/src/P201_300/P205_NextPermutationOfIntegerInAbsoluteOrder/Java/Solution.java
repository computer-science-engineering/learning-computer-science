package DailyCodingProblem.src.P201_300.P205_NextPermutationOfIntegerInAbsoluteOrder.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(nextPermutation(48975));
    }

    public static int nextPermutation(int num) {
        String numString = Integer.toString(num);
        int[] nums = new int[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            nums[i] = numString.charAt(i) - '0';
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        StringBuilder sb = new StringBuilder();
        for (int digit : nums) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}