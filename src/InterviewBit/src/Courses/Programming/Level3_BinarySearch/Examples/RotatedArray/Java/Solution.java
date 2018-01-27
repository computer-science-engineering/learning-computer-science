package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Examples.RotatedArray.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 5, 6, 7, 0, 1, 2);
        System.out.println(findMin(input));
    }
    
    public static int findMin(final List<Integer> a) {
        int n = a.size();
        int numOfRotations=0;
        int low = 0, high = n-1;
        while(low<=high) {
            if (a.get(low) <= a.get(high)) { // Case 1
                numOfRotations = low;
                return a.get(numOfRotations);
            }
            int mid = (low+high)/2;
            int next = (mid+1)%n, prev=(mid+n-1)%n;
            if (a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev)) { // Case 2
                numOfRotations = mid;
                return a.get(numOfRotations);
            }
            else if (a.get(mid) <= a.get(high)) { // Case 3
                high = mid-1;
            }
            else if (a.get(mid) >= a.get(low)) { // Case 4
                low = mid+1;
            }
        }
        return a.get(numOfRotations);
	}
}