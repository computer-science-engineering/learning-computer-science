package LeetCode.src.Explore.Interview.GoogleInterview.Design.RangeSumQuery2DMutable.Java;

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
        for (int i = row + 1; i <= m; i += i & (-i)) {  // remember tree is indexed by rLen & cLen, off-by-one index; getNext
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
        // Sum(r,c) means "the sum of all elements in the first r rows and c cols."
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }

    public int sum(int row, int col) {
        // remember tree is indexed by rLen & cLen, off-by-one index
        int rLen = row + 1;
        int cLen = col + 1;
        int sum = 0;
        for (int i = rLen; i > 0; i -= i & (-i)) { // getParent
            for (int j = cLen; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}