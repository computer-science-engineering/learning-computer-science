package Courses.Programming.Level2_Math.Problems.Adhoc.SumOfPairwiseHammingDistance;

public class Solution {
    public static void main(String[] args) {
        int[] input = {2, 4, 6};
        // int[] input = {1, 3, 5};
        System.out.println(hammingDistance(input));
        System.out.println(sumOfBitDiffAmongAllPairs(input));
    }
    
    // O(n) time complexity
    public static int hammingDistance(final int[] A) {
        long result = 0;
        for (int i=0; i<32; i++) {
            int count = 0; // number of set bits in the array at the ith position
            for (int j=0; j<A.length; j++) {
                // 1<<i = 1*pow(2,i); 1>>i = 1/pow(2,i); & implies modulo
                if ((A[j] & (1<<i)) != 0) { 
                    count++;
                }
            }
            //result += (count*(A.length-count)*2);
            result = (result + (2L * count * (A.length-count))% 1000000007)% 1000000007;
        }
        return (int)result;
    }

    // O(n^2) time complexity
    private static int sumOfBitDiffAmongAllPairs(int[] arr) {
		int sum = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length;j++) {
				if(arr[i] != arr[j]) { //diff is zero for pair with same numbers, hence ignore
					int xor = arr[i] ^ arr[j]; // xor gives the difference between two numbers
					while(xor>0) { // set bits for the difference between two numbers
						xor&=xor-1;
						sum++;
					}
				}
			}
        }
        return sum;
	}
}