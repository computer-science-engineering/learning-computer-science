package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.ArrayMath.MinStepsInInfiniteGrid.Java;

import java.util.*;

public class Solution{
    public static void main(String[] args) {
        ArrayList<Integer> X = new ArrayList<Integer>();
        X.add(7);
        X.add(2);
        X.add(4);
        X.add(1);
        ArrayList<Integer> Y = new ArrayList<Integer>();
        Y.add(1);
        Y.add(5);
        Y.add(3);
        Y.add(8);

        System.out.println(coverPoints(X, Y));
    }    

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        if (X.size() != Y.size()) {
            throw new RuntimeException("Incorrect arguments: Size of X and Y lists do not match.");
        }
        int result = 0;
        for (int i=1; i<X.size(); i++) {
            result += Math.max(Math.abs(X.get(i)-X.get(i-1)), Math.abs(Y.get(i)-Y.get(i-1)));
        }
        return result;
    }
}