package ElementsOfProgrammingInterviews.src.C6_Arrays.Q14_ComputeRandomSubset.Java;

import java.util.*;

public class OnlineSampling {
    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> changedElements = new HashMap<>();
        Random randIdxGen = new Random();
        for (int i = 0; i < k; ++i) {
            // Generate random int in [i, n - 1].
            int randIdx = i + randIdxGen.nextInt(n - i);
            Integer ptr1 = changedElements.get(randIdx);
            Integer ptr2 = changedElements.get(i);
            if (ptr1 == null && ptr2 == null) {
                changedElements.put(randIdx, i);
                changedElements.put(i, randIdx);
            } else if (ptr1 == null && ptr2 != null) {
                changedElements.put(randIdx, ptr2);
                changedElements.put(i, randIdx);
            } else if (ptr1 != null && ptr2 == null) {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, i);
            } else {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, ptr2);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            result.add(changedElements.get(i));
        }
        return result;
    }
}
