package ElementsOfProgrammingInterviews.src.C6_Arrays.Q4_AdvancingThroughAnArray.Java;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public static boolean canReachEnd(List<Integer> maxAdvanceSteps){
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size()-1;
        for (int i=0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i){
            furthestReachSoFar = Math.max(furthestReachSoFar, i+maxAdvanceSteps.get(i));
        }
        return furthestReachSoFar >= lastIndex;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(3);
        a.add(1);
        a.add(0);
        a.add(2);
        a.add(0);
        a.add(1);
        boolean result = canReachEnd(a);
        System.out.println(result);
    }
}
