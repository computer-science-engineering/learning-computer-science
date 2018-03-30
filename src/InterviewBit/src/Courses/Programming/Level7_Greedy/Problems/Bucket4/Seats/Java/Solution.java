package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket4.Seats.Java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        String A = "....x..xx...x..";
        System.out.println(seats_BruteForce(A));
        System.out.println(seats(A));
        System.out.println(seats2(A));
        System.out.println(seats_Editorial(A));
    }

    public static int seats(String A) {
        int MOD = 10000003;
        char[] seats = A.toCharArray();

        // step 1. add all groups to deque
        Deque<int[]> dq = new ArrayDeque<>();
        
        int i = 0, j = 0, n = seats.length;
        
        while (j < n) {
            // skip '.'
            while (j < n && seats[j] == '.') j++;
            if (j == n) break;
            // go through 'x'
            for (i = j; j < n && seats[j] == 'x'; j++) {}
            // add group to deque
            dq.addLast(new int[]{i, j - 1});
        }
        
        // step 2. merge groups from both ends
        int count = 0;
        
        while (dq.size() > 1) {
            int[] left = dq.peekFirst();
            int[] right = dq.peekLast();
            
            int lenLeft = left[1] - left[0] + 1;
            int lenRight = right[1] - right[0] + 1;
            
            if (lenLeft <= lenRight) {
            // merge left two groups
            left = dq.pollFirst();
            count += lenLeft * (dq.peekFirst()[0] - left[1] - 1);
            dq.peekFirst()[0] -= lenLeft;
            } else {
                // merge right two groups
                right = dq.pollLast();
                count += lenRight * (right[0] - dq.peekLast()[1] - 1);
                dq.peekLast()[1] += lenRight;
            }
        }

        return count % MOD;
    }
    
    public static int seats2(String A) {
        int MOD = 10000003;
        int ans = 0;
        int count = 0;
        int space = 0;
        int n = 0;
        char[] a = A.toCharArray();
        for(int i = 0; i<a.length; i++) {
            if(a[i]=='x') {
                n++; // n is total number of occupied seats 
            }
        }
        for(int i=0; i<a.length; i++) {
            if(a[i]=='x') {
                if(space!=0) {
                    // Either you can move left occupied seats to right or right occupied seats to left. Choose the one in which you have to move less number of elements. For example ***....******.... in this case of course we would like to move left part to right and not vice versa.
                    ans += Math.min(n-count, count)*space;
                    space = 0;
                }
                count++;
            } else {
                space++;
            }
        }
        return ans % MOD;
    }

    public static int seats_BruteForce(String A) {
        int MOD = 10000003;
        char[] seats = A.toCharArray();
        int n = seats.length;
        // step 1. count people
        int k = 0;
        for (int i=0; i<n; i++) {
            if (seats[i] == 'x') {
                k++;
            }
        }

        // step 2. move the window of size k and count the hops
        int min = Integer.MAX_VALUE;

        for (int j=0; j<n-k; j++) {
            int hops=0, p = j;

            for (int i=0; i<n; i++) {
                if (seats[i] == 'x') {
                    hops += Math.abs(i - p++);
                }
            }

            min = Math.min(min, hops);
        }

        return min % MOD;
    }

    // Editorial

    private static final long MOD = 10000003;
    
    private static final char OCCUPIED = 'x';
    
	public static int seats_Editorial(String a) {
	    int numLeft = 0;
	    int numRight = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (a.charAt(i) == OCCUPIED) {
	            ++numRight;
	        }
	    }
	    
	    long moves = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (numRight == 0) {
	            break;
	        } else if (a.charAt(i) == OCCUPIED) {
                ++numLeft;
                --numRight;
	        } else {
	            moves += Math.min(numLeft, numRight);
	        }
	    }
	    return (int) (moves % MOD);
	}
}