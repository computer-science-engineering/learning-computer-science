package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket2.GasStation.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {2, 1};
        System.out.println(canCompleteCircuit1(A, B));
        System.out.println(canCompleteCircuit2(A, B));
        System.out.println(canCompleteCircuit_Editorial(A, B));
    }

    // A - gas; B - cost
    public static int canCompleteCircuit1(final int[] A, final int[] B) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < A.length; i++) {
            sumGas += A[i];
            sumCost += B[i];
            tank += A[i] - B[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }    
    
    public static int canCompleteCircuit2(final int[] A, final int[] B) {
        int total = 0;
        for(int i=0; i<A.length; i++) {
            total += A[i] - B[i];
        }
        if(total<0) {
            return -1;
        }

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < A.length; i++) {
            if(accumulate + A[i] - B[i] < 0) {
                start = i+1;
                accumulate = 0;
            } else {
                accumulate += A[i] - B[i];
            }
        }
        return start;
    }

    public static int canCompleteCircuit_Editorial(final int[] A, final int[] B) {
        int currentFuel = 0;
	    int remaining = 0;
	    int total = 0;
	    int start = 0;
	    for(int i = 0; i < A.length; i++) {
	        remaining = A[i] - B[i];
	        if(currentFuel >= 0)
	            currentFuel += remaining;
	        else {
	            currentFuel = remaining;
	            start = i;
	        }
	        total += remaining;
	    }
	    return total >= 0 ? start : -1;
    }
}