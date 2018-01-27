package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q5_DeleteDuplicatesFromSortedArray.Variants.LimitDuplicates.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int limitDups(List<Integer> input, int m){
        if (input.isEmpty()){
            return 0;
        }

        int writeIndex = 1;
        int occurrences = 1;
        boolean updatedWriteIndex = false;
        for (int i=1; i<input.size(); i++){
            if (!input.get(writeIndex-1).equals(input.get(i))){
                if (occurrences >= m){
                    //writeIndex = i - (occurrences - m);
                    //input.set(writeIndex++, input.get(i));
                }
                input.set(writeIndex++, input.get(i));
                occurrences=1;
                updatedWriteIndex = false;
            }
            else{
                occurrences++;
                if (!updatedWriteIndex && occurrences == m){
                    writeIndex = i+1;
                    updatedWriteIndex = true;
                }
            }
        }
        return writeIndex;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        int uniqueEntries = limitDups(a, 2);
        System.out.println(uniqueEntries);
        System.out.println(a.subList(0, uniqueEntries));
    }
}
