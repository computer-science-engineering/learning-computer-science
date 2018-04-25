package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Examples.FindElementOccurrence.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        System.out.println(findCount(A, 8));
    }

    public static int findCount(final int[] A, int B) {
        int firstIndex = getStartIndex(A, B);
        if (firstIndex == -1) {
            return 0;
        }
        int count = 1;
        for (int i=firstIndex-1; i>=0; i--) {
            if (A[i] == B) {
                count++;
            }
            else {
                break;
            }
        }
        for (int i=firstIndex+1; i<=A.length-1; i++) {
            if (A[i] == B) {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
    
    public static int getStartIndex(int[] A, int B) {
        int start = 0;
        int end = A.length-1;
        while(start<=end) {
            int mid = start + ((end-start)/2);
            if (A[mid] == B) {
                return mid;
            }
            else if (B < A[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }
}