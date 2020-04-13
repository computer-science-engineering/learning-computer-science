package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_KWayMerge.P3_KthSmallestNumberInASortedMatrix.Java;

public class SolutionAlternative1 {
    public static void main(String[] args) {
        int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int result = findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            // first number is the smallest and the second number is the largest
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};

            int count = countLessEqual(matrix, mid, smallLargePair);

            if (count == k) {
                return smallLargePair[0];
            }

            if (count < k) {
                start = smallLargePair[1]; // search higher
            } else {
                end = smallLargePair[0]; // search lower
            }
        }

        return start;
    }

    private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the
                // smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the
                // biggest number less than or equal to the mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}
