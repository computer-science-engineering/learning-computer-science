package EducativeIo.Courses.GrokkingTheCodingInterview.Ch16_01Knapsack_DynamicProgramming.P2_EqualSubsetSumPartition.Java;

public class Solution2TopDownDpWithMemoization {
    public static void main(String[] args) {
        Solution2TopDownDpWithMemoization ps = new Solution2TopDownDpWithMemoization();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[] {1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[] {2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
        return this.canPartitionRecursive(dp, num, sum / 2, 0);
    }

    private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0) {
            return true;
        }

        if (num.length == 0 || currentIndex >= num.length) {
            return false;
        }

        // if we have not already processed a similar problem
        if (dp[currentIndex][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            // recursive call after excluding the number at the currentIndex
            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }
}
