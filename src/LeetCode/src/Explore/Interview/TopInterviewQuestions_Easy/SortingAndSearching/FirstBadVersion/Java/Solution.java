package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.SortingAndSearching.FirstBadVersion.Java;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }         
        }        
        return start;
    }

    private static boolean isBadVersion(int n) {
        if (n == 4 || n == 5) {
            return true;
        }
        return false;
    }
}