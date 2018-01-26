package ElementsOfProgrammingInterviews.src.Book.C6_Arrays.Q11_SampleOfflineData.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OfflineSampling {
    public static void randomSampling(int k, List<Integer> A){
        Random gen = new Random();
        for(int i=0; i<k; ++i){
            // Generate a random int in [i, A.size()-1].
            // System.out.println("i: " + i);
            // System.out.println("gen.nextInt(A.size()-i): " + gen.nextInt(A.size()-i));
            Collections.swap(A, i, i+gen.nextInt(A.size()-i));
        }
    }

    public static void main(String[] args){
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(7);
        A.add(5);
        A.add(11);
        int k = 3;
        randomSampling(k, A);
        List<Integer> B = new ArrayList<>();
        for (int i=0; i<k; i++){
            B.add(i, A.get(i));
        }
        System.out.println(B);
    }
}
