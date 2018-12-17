package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.TrappingRainWater.Java;

public class Solution {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int a=0;
        int b=height.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b) {
            leftmax=Math.max(leftmax,height[a]);
            rightmax=Math.max(rightmax,height[b]);
            if(leftmax<rightmax) {
                max+=(leftmax-height[a]);
                a++;
            }
            else {
                max+=(rightmax-height[b]);
                b--;
            }
        }
        return max;
    }
}