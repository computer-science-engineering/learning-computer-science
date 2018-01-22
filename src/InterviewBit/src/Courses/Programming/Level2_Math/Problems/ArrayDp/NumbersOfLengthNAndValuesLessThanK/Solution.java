package InterviewBit.src.Courses.Programming.Level2_Math.Problems.ArrayDp.NumbersOfLengthNAndValuesLessThanK;

public class Solution {
    public static void main(String[] args) {        
    }

    public int solve(int[] A, int B, int C) {
        int d = A.length;
        if (d==0 || B > String.valueOf(C).length()) {
            return 0;
        }

        if (B < String.valueOf(C).length()) {
            boolean containsZero = containsNumber(A, 0);
            if (containsZero) {
                return (int)Math.pow(d, B);
            }
            else {
                return (int)((d-1)*Math.pow(d, B-1));
            }
        }
        int result = 0;
        return result;
    } 

    private static boolean containsNumber(int[] A, int number) {
        for (int i=0; i<A.length; i++) {
            if (A[i] == number) {
                return true;
            }
        }
        return false;
    }
}