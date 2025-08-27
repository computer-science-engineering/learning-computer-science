package EducativeIo.Courses.GrokkingTheCodingInterview.Ch16_01Knapsack_DynamicProgramming.P2_EqualSubsetSumPartition.Java;

public class Solution3BottomUpDp {
    public static void main(String[] args) {
        Solution3BottomUpDp ps = new Solution3BottomUpDp();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[] {1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[] {2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

    public boolean canPartition(int[] num) {
        int n = num.length;
        // find the total sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with same total
        if (sum % 2 != 0) {
            return false;
        }

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 columns, as we can always for '0' sum with an empty set
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to its
        // value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        // the bottom-right corner will have our answer.
        return dp[n - 1][sum];
    }
}
