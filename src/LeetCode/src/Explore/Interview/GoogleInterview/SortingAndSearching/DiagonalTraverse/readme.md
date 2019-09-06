# Problem Definition

## Description

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

**Example:**

```plaintext
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:
```

![image](https://assets.leetcode.com/uploads/2018/10/12/diagonal_traverse.png)

**Note:**

The total number of elements of the given matrix will not exceed 10,000.

## Notes

1. [LeetCode discussion - Concise Java Solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/452/discuss/97712/Concise-Java-Solution)

    Walk patterns:

    * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
    * if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
    * if out of top border (row < 0) then row = 0; change walk direction.
    * if out of left border (col < 0) then col = 0; change walk direction.
    * Otherwise, just go along with the current direction.

    Time complexity: O(m * n), m = number of rows, n = number of columns.

    Space complexity: O(1).

    ```java
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }

        return result;
    }
    ```

1. LeetCode sample submission - 3 ms

    ```java
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length ==0 || (matrix[0].length==0)) {
           return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int i=0;
        int j=0;
        int index=0;
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        res[index++]=matrix[i][j];
        if(j==col) {
            i++;
        } else {
            j++;
        }
        boolean down=true;
        while(i<=row && j <=col){
           res[index++]=matrix[i][j];
            if(down){
                if(j-1 >=0 && i+1 <=row) {
                    i++;
                    j--;
                } else if(i!=row) {
                    i++;
                    down=false;
                } else {
                    j++;
                    down=false;
                }
            } else {
                if(i-1 >=0 && j+1 <=col) {
                    i--;
                    j++;
                } else if(j!=col) {
                    j++;
                    down=true;
                } else {
                    i++;
                    down=true;
                }
            }
        }
        return res;
    }
    ```