package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q9_PermuteElementsOfArray.Java;

import java.util.ArrayList;
import java.util.List;

public class PermutationArray2 {
    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < A.size(); ++i) {
            // Traverses the cycle to see if i is the minimum element.
            boolean isMin = true;
            int j = perm.get(i);
            while (j != i) {
                if (j < i) {
                    isMin = false;
                    break;
                }
                j = perm.get(j);
            }

            if (isMin) {
                cyclicPermutation(i, perm, A);
            }
        }
        System.out.println(A);
    }

    private static void cyclicPermutation(int start, List<Integer> perm,
                                          List<Integer> A) {
        int i = start;
        int temp = A.get(start);
        do {
            int nextI = perm.get(i);
            int nextTemp = A.get(nextI);
            A.set(nextI, temp);
            i = nextI;
            temp = nextTemp;
        } while (i != start);
    }

    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        perm.add(3);
        perm.add(1);
        perm.add(2);
        perm.add(0);
        applyPermutation(perm, A);
    }
}
