package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q4_AdvancingThroughAnArray.Variants.Java;

// http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfSteps {
    public static int minSteps(List<Integer> input){
        int furthestReachSoFar = 0, lastIndex = input.size()-1;
        int result = 0;
        for(int i=0; i<=furthestReachSoFar && furthestReachSoFar<lastIndex; ++i){
            furthestReachSoFar = Math.max(furthestReachSoFar, i+input.get(i));
            result = i;
        }
        if (furthestReachSoFar >= lastIndex) {
            return result + 1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(6);
        a.add(1);
        a.add(0);
        a.add(9);

        /*a.add(1);
        a.add(3);
        a.add(5);
        a.add(8);
        a.add(9);
        a.add(2);
        a.add(6);
        a.add(7);
        a.add(6);
        a.add(8);
        a.add(9);*/
        int result = minSteps(a);
        System.out.println(result);
    }
}
