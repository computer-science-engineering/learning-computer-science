package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P11_RearrangeString.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Rearranged string: " + rearrangeString("aappp"));
        System.out.println("Rearranged string: " + rearrangeString("Programming"));
        System.out.println("Rearranged string: " + rearrangeString("aapa"));
    }

    public static String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Character, Integer>>(
                        (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        // if we were successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }
}
