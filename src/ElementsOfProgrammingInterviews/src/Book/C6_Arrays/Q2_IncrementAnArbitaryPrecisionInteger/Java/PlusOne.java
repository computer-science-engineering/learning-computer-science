package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q2_IncrementAnArbitaryPrecisionInteger.Java;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static List<Integer> plusOne(List<Integer> input) {
        int n = input.size() - 1;
        input.set(n, input.get(n) + 1);
        for (int i=n; i>0 && input.get(i) == 10; --i){
            input.set(i, 0);
            input.set(i-1, input.get(i-1)+1);
        }
        if (input.get(0) == 10){
            // Need additional digit as the most significant digit (i.e., input.get(0) has a carry-out).
            input.set(0, 0);
            input.add(0, 1);
        }
        return input;
    }

    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(9);
        List<Integer> result = plusOne(input);
        System.out.println(result);
    }
}
