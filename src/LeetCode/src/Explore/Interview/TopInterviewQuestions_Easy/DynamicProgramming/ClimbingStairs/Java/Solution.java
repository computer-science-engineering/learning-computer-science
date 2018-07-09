package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.DynamicProgramming.ClimbingStairs.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
            
        int[] store = new int[n];
        
        store[0] = 1;
        store[1] = 2;
        
        for(int i = 2; i < n; ++i) {
            store[i] = store[i-1] + store[i-2];
        }
            
        return store[n-1];
    }
}