package HackerRank.src.Tracks.ProblemSolving.Algorithms.Implementation.DivisibleSumPairs.Java;

public class Solution {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        in.close();*/
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};
        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

    public static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                int sum = ar[i] + ar[j];
                if (sum % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }    
}