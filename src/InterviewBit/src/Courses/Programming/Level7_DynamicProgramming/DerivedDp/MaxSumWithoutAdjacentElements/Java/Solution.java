package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DerivedDp.MaxSumWithoutAdjacentElements.Java;

public class Solution {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        System.out.println(adjacent(A));
    }
    
    public static int adjacent(int[][] A) {
        int n = A[0].length;
        // Sum including maximum element of first
        // column
        int incl = Math.max(A[0][0], A[1][0]);
      
        // Not including first column's element
        int excl = 0, excl_new;
      
        // Traverse for further elements
        for (int i = 1; i < n; i++ ) {
            // Update max_sum on including or 
            // excluding of previous column
            excl_new = Math.max(excl, incl);
      
            // Include current column. Add maximum element
            // from both row of current column
            incl = excl + Math.max(A[0][i], A[1][i]);
      
            // If current column doesn't to be included
            excl = excl_new;
        }
      
        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);
    }
}