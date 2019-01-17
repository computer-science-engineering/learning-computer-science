# Problem Definition

## Description

Given a 2D matrix _matrix_, find the sum of the elements inside the rectangle defined by its upper left corner (_row1_, _col1_) and lower right corner (_row2_, _col2_).

![Range Sum Query 2D](https://leetcode.com/static/images/courses/range_sum_query_2d.png)

The above rectangle (with the red border) is defined by (row1, col1) = **(2, 1)** and (row2, col2) = **(4, 3)**, which contains sum = 8.

**Example:**

```text
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
```

**Note:**

1. The matrix is only modifiable by the _update_ function.
2. You may assume the number of calls to _update_ and _sumRegion_ function is distributed evenly.
3. You may assume that _row1_ ≤ _row2_ and _col1_ ≤ _col2_.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/range-sum-query-2d-immutable/solution/)
1. [LeetCode discussion - Java 2D Binary Indexed Tree Solution clean and short 17ms](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms)

    ```java
    class NumMatrix {
        // Instance variables
        int[][] tree;   // bit tree, sumNums(0->i) will be stored at tree(i+1), tree is reference by Length
        int[][] nums;   // a deep clone of the input matrix. otherwise matrix might be updated by other process
        int m;          // num of rows
        int n;          // num of cols

        // Constructor initialization
        public NumMatrix(int[][] matrix) {
            // input checks
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            // initialize variables
            m = matrix.length;
            n = matrix[0].length;
            tree = new int[m+1][n+1];
            // deep clone matrix for reference, to prevent other process change matrix
            nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        // Function similar to Map.put(Key, Val), key is (row, col), new value is (val)
        public void update(int row, int col, int val) { 
            // input validation: empty matrix || row col not in range
            if (m == 0 || n == 0 || row < 0 || row > m || col < 0 || col > n) { 
                return; 
            }
            // update cloned matrix: nums
            int oldVal = nums[row][col];
            nums[row][col] = val;
            // update bit tree with delta
            int delta = val - oldVal;
            for (int i = row + 1; i <= m; i += i & (-i)) {  // remember tree is indexed by rLen & cLen, off-by-one index
                for (int j = col + 1; j <= n; j += j & (-j)) { 
                    tree[i][j] += delta;
                }
            }
        }

        // Assume row1 <= row2 and col1 <= col2. both 0-base index and all input within range
        public int sumRegion(int row1, int col1, int row2, int col2) {
            // input validation: empty matrix || row col not in range
            if (m == 0 || n == 0 || row1 < 0 || row1 > m || col1 < 0 || col1 > n || row2 < 0 || row2 > m || col2 < 0 || col2 > n) { 
                return 0; 
            }
            // used 4 rectangle areas [(0, 0), (x, y)] to compute wanted area
            // think about cases where row1 || col1 might be 0
            return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
        }

        public int sum(int row, int col) {
            // remember tree is indexed by rLen & cLen, off-by-one index
            int rLen = row + 1;
            int cLen = col + 1;
            int sum = 0;
            for (int i = rLen; i > 0; i -= i & (-i)) {
                for (int j = cLen; j > 0; j -= j & (-j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }
    }
    // time should be O(log(m) * log(n))
    ```

    [Explanation of Binary Indexed Tree at TopCoder](https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/)

    More [here](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms/79038) and [here](https://www.youtube.com/watch?v=CWDQJGaN1gY).

1. [LeetCode discussion - Segment Tree Solution in Java](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75863/Segment-Tree-Solution-in-Java)
1. [LeetCode discussion - 15ms easy to understand java solution](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75852/15ms-easy-to-understand-java-solution)

    We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j], matrix[2][j],......,matrix[i - 1][j] ).

    ```java
    private int[][] colSums;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if(   matrix           == null
        || matrix.length    == 0
        || matrix[0].length == 0   ){
            return;
        }
        this.matrix = matrix;
        int m   = matrix.length;
        int n   = matrix[0].length;
        colSums = new int[m + 1][n];
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < n; j++){
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
    //time complexity for the worst case scenario: O(m)
    public void update(int row, int col, int val) {
        for(int i = row + 1; i < colSums.length; i++){
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }
    //time complexity for the worst case scenario: O(n)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for(int j = col1; j <= col2; j++){
            ret += colSums[row2 + 1][j] - colSums[row1][j];
        }
        return ret;
    }
    ```

1. [LeetCode discussion - Share my Java 2-D Binary Indexed Tree Solution](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75917/Share-my-Java-2-D-Binary-Indexed-Tree-Solution)
1. [LeetCode discussion - 15ms Very Concise Java Code Using BIT](https://leetcode.com/explore/interview/card/google/65/design-4/477/discuss/75905/15ms-Very-Concise-Java-Code-Using-BIT)

    ```java
    public class NumMatrix {
        // Using 2D Binary Indexed Tree, 2D BIT Def:
        // bit[i][j] saves the rangeSum of [i-(i&-i), i] x [j-(j&-j), j]
        // note bit index == matrix index + 1
        int n, m;
        int[][] bit, a;

        public NumMatrix(int[][] matrix) {
            if (matrix.length < 1) return;
            n = matrix.length; m = matrix[0].length;
            bit = new int[n + 1][m + 1]; a = new int[n][m];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    update(i, j, matrix[i][j]);
        }

        public void update(int row, int col, int val) {
            int diff = val - a[row][col];
            a[row][col] = val;
            for (int i = row + 1; i <= n; i += i & -i)
                for (int j = col + 1; j <= m; j += j & -j)
                    bit[i][j] += diff;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
        }

        public int sum(int row, int col) {
            int tot = 0;
            for (int i = row + 1; i > 0; i -= i & -i)
                for (int j = col + 1; j > 0; j -= j & -j)
                    tot += bit[i][j];
            return tot;
        }
    }
    ```