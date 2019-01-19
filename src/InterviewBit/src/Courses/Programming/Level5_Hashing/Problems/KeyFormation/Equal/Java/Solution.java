package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.KeyFormation.Equal.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1));
        ArrayList<Integer> result = equal(A);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }

    public static ArrayList<Integer> equal(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        int sum = 0;
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        for(int i =0; i < n-1; i++){
            for(int j = i + 1; j < n; j++) {
                sum = A.get(i) + A.get(j);
                Pair p = new Pair(i, j);
                if(map.containsKey(sum)) {
                    boolean add = true;                    
                    ArrayList<Pair> list = map.get(sum);
                    for (Pair pair : list) {
                        if (pair.x == i || pair.x == j || pair.y == i || pair.y == j) {
                            add = false;
                        }
                    }
                    if (add) {
                        list.add(p);
                        map.remove(sum);                    
                        map.put(sum,list);
                    }
                }
                else {
                    ArrayList<Pair> list = new ArrayList<Pair>();
                    list.add(p);
                    map.put(sum, list);
                }
            }
        }
        Set<Map.Entry<Integer, ArrayList<Pair>>> set = map.entrySet();
        Iterator<Map.Entry<Integer, ArrayList<Pair>>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Pair>> entry = (Map.Entry<Integer, ArrayList<Pair>>)iterator.next();
            //System.out.println("Key is: "+entry.getKey() + " & Value is: ");
            //System.out.println("\t" +  entry.getValue());
            ArrayList<Pair> items = (ArrayList<Pair>) entry.getValue();
            int l = items.size();
            if (l >= 2) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int i=0; i<2; i++) {
                    Pair pair = items.get(i);
                    temp.add(pair.x);
                    temp.add(pair.y);
                    //System.out.print(pair.toString());
                }
                //System.out.println();
                result.add(temp);
            }
        }
        // result.sort((o1, o2) -> {
        //     if (o1.get(0) < o2.get(0)) {
        //         return o1;
        //     }
        // });
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                //return o1.get(0).compareTo(o2.get(0));
                if (o1.get(0) < o2.get(0)) {
                    return -1;
                }
                else if (o1.get(0) > o2.get(0)) {
                    return 1;
                }
                else { // ==
                    if (o1.get(1) < o2.get(1)) {
                        return -1;
                    }
                    else if (o1.get(1) > o2.get(1)) {
                        return 1;
                    }
                    else { // ==
                        if (o1.get(2) < o2.get(2)) {
                            return -1;
                        }
                        else if (o1.get(2) > o2.get(2)) {
                            return 1;
                        }
                        else { // ==
                            if (o1.get(3) < o2.get(3)) {
                                return -1;
                            }
                            else if (o1.get(3) > o2.get(3)) {
                                return 1;
                            }
                            else { // ==
                                return 0;
                            }
                        }
                    }
                }
            }
        });
        return result.get(0);
    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            String s = "[" + x + ", " + y + "]";
            return s;
        }
    }
}