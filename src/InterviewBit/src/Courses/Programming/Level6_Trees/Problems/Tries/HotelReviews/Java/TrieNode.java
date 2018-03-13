package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Tries.HotelReviews.Java;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;
    int count;

    TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
        count = 1;
    }
}