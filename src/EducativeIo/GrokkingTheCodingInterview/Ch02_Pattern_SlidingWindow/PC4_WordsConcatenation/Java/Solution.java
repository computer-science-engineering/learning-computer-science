package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.PC4_WordsConcatenation.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catfoxcat", new String[] {"cat", "fox"});
        System.out.println(result);
        result = findWordConcatenation("catcatfoxfox", new String[] {"cat", "fox"});
        System.out.println(result);
    }


    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        int wordsCount = words.length, wordLength = words[0].length();
        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) { // break if we don't need this word
                    break;
                }
                // add the word to the 'wordsSeen' map
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0)) {
                    break;
                }
                if (j + 1 == wordsCount) { // store index if we have found all the words
                    resultIndices.add(i);
                }
            }
        }

        return resultIndices;
    }
}
