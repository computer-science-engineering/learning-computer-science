package InterviewBit.src.Courses.Programming.Level2_Math.Problems.Combinatorics.GridUniquePaths.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(14, 14));
        //System.out.println(uniquePaths2(14, 14));
    }
    
    public static int uniquePaths(int a, int b) {
        return findAllOptimized(0, 0, a, b, 0, "");
	}
	
	/*public static int uniquePaths2(int a, int b) {
        return findAll(0, 0, a, b, 0, "");
    }
    
    private static int findAll(int currentRow, int currentColumn, int rowCount, int colCount, int pathCount, String path) {
		if (currentRow == rowCount - 1) {
			for (int i = currentColumn; i < colCount; i++) {
				path += "-" + "[" + currentRow + "," + i + "]";
			}
            pathCount++;
			//System.out.println(path);
			return pathCount;
		}
		if (currentColumn == colCount - 1) {
			for (int i = currentRow; i <= rowCount - 1; i++) {
				path += "-" + "[" + i + "," + currentColumn + "]";
			}
            pathCount++;
			//System.out.println(path);
			return pathCount;
		}
		path = path + "-" + "[" + currentRow + "," + currentColumn + "]";
		pathCount = findAll(currentRow + 1, currentColumn, rowCount, colCount, pathCount, path);
        pathCount = findAll(currentRow, currentColumn + 1, rowCount, colCount, pathCount, path);
        return pathCount;
    }*/
    
    private static int findAllOptimized(int currentRow, int currentColumn, int rowCount, int colCount, int pathCount, String path) {
		if (currentRow == rowCount - 1) {
            pathCount++;
			return pathCount;
		}
		if (currentColumn == colCount - 1) {
            pathCount++;
			return pathCount;
		}
		pathCount = findAllOptimized(currentRow + 1, currentColumn, rowCount, colCount, pathCount, path);
        pathCount = findAllOptimized(currentRow, currentColumn + 1, rowCount, colCount, pathCount, path);
        return pathCount;
	}
}