package ElementsOfProgrammingInterviews.src.C6_Arrays.Q5_DeleteDuplicatesFromSortedArray.Java;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    // Returns the number of valid entries after deletion.
    public static int deleteDuplicates(List<Integer> A){
        if (A.isEmpty()) {
            return 0;
        }

        int writeIndex = 1;
        for (int i=1; i<A.size(); ++i) {
            if (!A.get(writeIndex-1).equals(A.get(i))){
                A.set(writeIndex++, A.get(i));
            }
        }
        return writeIndex;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(3);
        a.add(1);
        int uniqueEntries = deleteDuplicates(a);
        for (int i=uniqueEntries; i<a.size(); i++){
            a.remove(i);
        }
        System.out.println(a);
    }
}
