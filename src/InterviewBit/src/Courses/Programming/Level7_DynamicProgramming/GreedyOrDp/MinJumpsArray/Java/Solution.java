package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.GreedyOrDp.MinJumpsArray.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4};
        System.out.println(jump(A));  
        System.out.println(jump_optimized(A));    
        System.out.println(jump_Editorial(A));        
    }
    
    public static int jump(int[] A) {
        if (A == null) {
            return -1;
        }

        int n = A.length;

        if (n == 1 && A[0] == 0) {
            return 0; // special case
        }
        
        if (n == 0 || A[0] == 0) {
            return -1; // if first element is 0, end cannot be reached
        }

        int jumps[] = new int[n];  // jumps[n-1] will hold the result
        int i, j;
            
        jumps[0] = 0;
            
        // Find the minimum number of jumps to reach A[i]
        // from A[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + A[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n-1];
    }

    static int jump_optimized(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
 
        // Return -1 if not possible to jump
        if (A[0] == 0) {
            return -1;
        }
 
        // initialization
        int maxReach = A[0];
        int step = A[0];
        int jump = 1;
 
 
        // Start traversing array
        for (int i = 1; i < A.length; i++) {
            // Check if we have reached the end of the array
            if (i == A.length - 1) {
                return jump;
            }
 
            // updating maxReach
            maxReach = Math.max(maxReach, i+A[i]);
 
            // we use a step to get to the current index
            step--;
 
            // If no further steps left
            if (step == 0) {
                //  we must have used a jump
                jump++;
                  
                // Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach) {
                   return -1;
                }
 
                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }
 
        return -1;
    }

    public static int jump_Editorial(int[] A) {	    
	    if (A == null || (A.length > 1 && A[0] == 0)) {
            return -1;
        }
	        
	    if (A.length == 1) {
            return 0;
        }
	        
	    int count = A[0];
	    int n;
	    int max = 0;
	    int steps = 0;
	    
	    n = A.length;
	    
	    for (int i = 1; i < n; i++) {	        
	        count--;
	        max--;
	        max = Math.max(max, A[i]);
	        
	        if (i == n - 1) {
	            return steps + 1;
	        }
	        
	        if (count == 0) {
	            if (max < 0) {
                    return -1;
                }
	            
	            count = max;
	            max = 0;
	            steps++;
	        }	        
	    }
	    return steps;
	}
}