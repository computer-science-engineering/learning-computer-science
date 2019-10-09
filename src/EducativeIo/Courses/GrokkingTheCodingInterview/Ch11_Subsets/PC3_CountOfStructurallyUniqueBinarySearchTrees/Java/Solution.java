package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.PC3_CountOfStructurallyUniqueBinarySearchTrees.Java;

public class Solution {
    public static void main(String[] args) {
        int count = countTrees(3);
        System.out.print("Total trees: " + count);
    }

    public static int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }
}
