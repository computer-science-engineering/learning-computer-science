# Problem Definition

## Description

Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

**Example 1:**

```text
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
```

**Note:**

1. The value in the given matrix is in the range of [0, 255].
2. The length and width of the given matrix are in the range of [1, 150].

## Notes

1. [LeetCode discussion - Very Clean Solution in Java](https://leetcode.com/explore/interview/card/google/59/array-and-strings/442/discuss/106602/Very-Clean-Solution-in-Java)
1. LeetCode submission - 11ms

    ```java
    public int[][] imageSmoother(int[][] M) {
        int xlen = M.length;
        int ylen = M[0].length;

        int[][] res = new int[xlen][ylen];

        for(int i=0; i<xlen; i++){
            for(int j = 0; j<ylen; j++){
                res[i][j] = smooth(i,j, M);
            }
        }
        return res;
    }

    public int smooth(int x, int y, int[][] M){
        int nx = M.length;
        int ny = M[0].length;
        int sum = 0;
        int count= 0;

        for(int i=-1; i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(x+i < 0 || x+i >= nx || y+j < 0 || y+j >= ny) {
                    continue;
                }
                count++;
                sum+=M[x+i][y+j];

            }
        }
        return sum/count;
    }
    ```