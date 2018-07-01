package DailyCodingProblem.src.P5_FirstAndLastElementOfPair.Java;

public class Solution {
    public static void main(String[] args) {
        cons pair = new cons(3, 4);
        System.out.println(car(pair));
        System.out.println(cdr(pair));
    }    

    public static int car(cons pair) {
        return pair.firstElement;
    }

    public static int cdr(cons pair) {
        return pair.secondElement;
    }
}