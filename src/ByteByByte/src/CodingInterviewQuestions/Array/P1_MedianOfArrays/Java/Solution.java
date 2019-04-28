package ByteByByte.src.CodingInterviewQuestions.Array.P1_MedianOfArrays.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input1 = {1, 3, 8, 9, 15};
        int[] input2 = {7, 11, 19, 21, 18, 25};
        System.out.println(findMedianSortedArrays(input1, input2));
    }

    public static double findMedianSortedArrays(int input1[], int input2[]) {
        if (input1.length > input2.length) {
            findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while(low <= high) {
            int partition_X = (low + high)/2;
            int partition_Y = (x + y + 1)/2 -  partition_X;

            int maxLeft_X = (partition_X == 0) ? Integer.MIN_VALUE : input1[partition_X - 1];
            int minRight_X = (partition_X == x) ? Integer.MAX_VALUE : input1[partition_X];

            int maxLeft_Y = (partition_Y == 0) ? Integer.MIN_VALUE : input2[partition_Y - 1];
            int minRight_Y = (partition_Y == y) ? Integer.MAX_VALUE : input2[partition_Y];

            if (maxLeft_X <= minRight_Y && maxLeft_Y <= minRight_X) {
                if ((x + y) % 2 == 0) {
                    return (double)(Math.max(maxLeft_X, maxLeft_Y) + Math.min(minRight_X, minRight_Y))/2;
                } else {
                    return (double)Math.max(maxLeft_X, maxLeft_Y);
                }
            } else if (maxLeft_X > minRight_Y) { // we are too far on right side for partition_X. Go on left side.
                high = partition_X - 1;
            } else { // we are too far on left side for partition_X. Go on right side.
                low = partition_X + 1;
            }
        }        

        // Input arrays were not sorted.
        throw new IllegalArgumentException();
    }
}