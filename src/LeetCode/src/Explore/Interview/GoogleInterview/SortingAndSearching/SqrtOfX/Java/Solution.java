package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.SqrtOfX.Java;

public class Solution {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x==1) {
            return 1;
        }
        double low = 0;
        double high = x;
        double mid = low + ((high - low) / 2);
    
        while (Math.abs((mid * mid) - x) >= 1) {
            if ((mid * mid) > x) {    
                high = mid;
                mid = (high - low) / 2;    
            } else {    
                low = mid;
                mid = mid + ((high - low) / 2);    
            }
        }
        return (int)Math.floor(mid);
    }
}