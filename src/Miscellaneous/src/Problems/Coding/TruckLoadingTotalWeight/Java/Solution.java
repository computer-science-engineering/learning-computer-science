package Miscellaneous.src.Problems.Coding.TruckLoadingTotalWeight.Java;

public class Solution {
    public static void main(String[] args) {
        String input = "+6b25 +50 -2b25 +10b20 -50";
        System.out.println(getTotalWeight(input));
    }

    public static int getTotalWeight(String input) {
        int totalWeight = 0;
        String[] items = input.split(" ");
        for (String item : items) {
            totalWeight += getWeight(item);            
        }
        return totalWeight;
    }

    private static int getWeight(String item) {
        boolean isAdd = false;
        char[] characters = item.toCharArray();
        if (characters[0] == '+') {
            isAdd = true;
        }
        if (item.indexOf("b") == -1) {
            if (isAdd) {
                return Integer.parseInt(item.substring(1));
            } else {
                return -1 * Integer.parseInt(item.substring(1));
            }
        } else {
            int indexOfB = item.indexOf("b");
            int count = Integer.parseInt(item.substring(1, indexOfB));
            int weightPerBox = Integer.parseInt(item.substring(indexOfB+1));
            int totalWeight = count * weightPerBox;
            if (isAdd) {
                return totalWeight;
            } else {
                return -1 * totalWeight;
            }
        }
    }
}