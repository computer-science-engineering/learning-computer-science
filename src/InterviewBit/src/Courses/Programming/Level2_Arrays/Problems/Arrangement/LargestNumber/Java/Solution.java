package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.Arrangement.LargestNumber.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution implements Comparator<String> {
    public static void main(String[] args) { 
        List<Integer> input = Arrays.asList(3, 30, 34, 5, 9);
        String result = largestNumber(input);
        System.out.println(result);
    }    

    public static String largestNumber(final List<Integer> a) {
        ArrayList<String> stringList = new ArrayList<String>();
        for (int item : a) {
            stringList.add(Integer.toString(item));
        }
        Collections.sort(stringList, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String fe = a + b;
                String se = b + a;
                return (fe.compareTo(se));
            }
        });
        StringBuilder ans = new StringBuilder();
        int sum = 0;
        for (int i = stringList.size() - 1; i >= 0; i--) {
            ans.append(stringList.get(i));
            sum += Integer.parseInt(stringList.get(i));
        }
        return sum == 0 ? "0" : ans.toString();
    }

    public int compare(String a, String b) {
        String fe = a + b;
        String se = b + a;
        return (fe.compareTo(se));
    }
}