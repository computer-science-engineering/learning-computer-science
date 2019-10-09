package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.PC1_EvaluateExpression.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }

    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }
}
