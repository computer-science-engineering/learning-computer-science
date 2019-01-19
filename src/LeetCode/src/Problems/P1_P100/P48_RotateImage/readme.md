# Problem Definition

## Description

You are given an *n x n* 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

**Note:**

You have to rotate the image [in-place](https://en.wikipedia.org/wiki/In-place_algorithm), which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

**Example 1:**

```text
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```

**Example 2:**

```text
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/rotate-image/solution/)
1. [LeetCode discussion - A common method to rotate the image](https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image)

    ```text
    /*
    * clockwise rotate
    * first reverse up to down, then swap the symmetry
    * 1 2 3     7 8 9     7 4 1
    * 4 5 6  => 4 5 6  => 8 5 2
    * 7 8 9     1 2 3     9 6 3
    */
    void rotate(vector<vector<int> > &matrix) {
        reverse(matrix.begin(), matrix.end());
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }

    /*
    * anticlockwise rotate
    * first reverse left to right, then swap the symmetry
    * 1 2 3     3 2 1     3 6 9
    * 4 5 6  => 6 5 4  => 2 5 8
    * 7 8 9     9 8 7     1 4 7
    */
    void anti_rotate(vector<vector<int> > &matrix) {
        for (auto vi : matrix) reverse(vi.begin(), vi.end());
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = i + 1; j < matrix[i].size(); ++j)
                swap(matrix[i][j], matrix[j][i]);
        }
    }
    ```

    [ref](https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image/139220):
    ```java
    /* Counter-clockwise Rotate */
    public void antiRotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int first=0, last=cols-1; first<last; first++,last--) {
            for(int i=0; i<matrix.length; i++) {
                int tmp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = tmp;
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = i+1; j < cols; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    ```