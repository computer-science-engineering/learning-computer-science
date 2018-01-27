package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SearchAnswer.SquareRootOfInteger.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sqrt(930675566)); //11-3; 930675566-30506; 1-1; 169078009-13003
    }
    
    public static int sqrt(int a) {
        if (a==1) {
            return 1;
        }
        double low = 0;
        double high = a;
        double mid = (high - low) / 2;
    
        while (Math.abs((mid * mid) - a) >= 1) {
            if ((mid * mid) > a) {    
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