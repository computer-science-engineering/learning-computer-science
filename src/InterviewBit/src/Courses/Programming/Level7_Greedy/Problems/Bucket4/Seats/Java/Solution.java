package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket4.Seats.Java;

public class Solution {
    public static void main(String[] args) {
        String A = "....x..xx...x..";
        System.out.println(seats(A));
        System.out.println(seats_BruteForce(A));
    }
    
    public static int seats(String A) {
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
                    // either you can move left occupied seats to right or right occupied seats to left choose the one in which you have to move less number of elements(for example ***....******.... in this case of course we would like to move left part to right and not vice versa.
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
}