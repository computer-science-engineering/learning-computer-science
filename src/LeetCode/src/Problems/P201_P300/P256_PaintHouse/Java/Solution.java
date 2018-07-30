package LeetCode.src.Problems.P201_P300.P256_PaintHouse.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};
        System.out.println(minCost(costs));
    }

    //The 1st row is the prices for the 1st house, we can change the matrix to present sum of prices from the 2nd row. i.e, the costs[1][0] represent minimum price to paint the second house red plus the 1st house.
    public static int minCost(int[][] costs) {
        if(costs==null || costs.length==0) {
            return 0;
        }
        for(int i=1; i<costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}