package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q3_MultipleTwoArbitaryPrecisionIntegers.Java;

import java.util.*;

public class BigNumberMultiplication {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
        for (int i=num1.size()-1; i>=0; --i){
            for (int j=num2.size()-1; j>=0; --j){
                result.set(i+j+1, result.get(i+j+1) + num1.get(i)*num2.get(j));
                result.set(i+j, result.get(i+j) + result.get(i+j+1)/10);
                result.set(i+j+1, result.get(i+j+1)%10);
            }
        }

        // Remove the leading zeroes.
        int first_not_zero = 0;
        while (first_not_zero < result.size() && result.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        result = result.subList(first_not_zero, result.size());
        if (result.isEmpty()) {
            return Arrays.asList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }

    public static void main(String[] args){
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);
        num2.add(9);
        num2.add(8);
        num2.add(7);
        List<Integer> result = multiply(num1, num2);
        System.out.println(result);
    }
}
