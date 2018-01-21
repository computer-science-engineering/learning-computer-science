package C6_Arrays.Q13_ComputeRandomPermutation.Java;

import C6_Arrays.Q11_SampleOfflineData.Java.OfflineSampling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputeRandomPermutation {
    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            permutation.add(i);
        }
        OfflineSampling.randomSampling(permutation.size(), permutation);
        return permutation;
    }

    public static void main(String[] args) {
        int n;
        Random gen = new Random();
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            n = gen.nextInt(1000000) + 1;
        }
        List<Integer> result = computeRandomPermutation(n);
        Collections.sort(result);
        for (int i = 0; i < n; ++i) {
            assert(i == result.get(i));
        }

        System.out.println(computeRandomPermutation(4));
    }
}
