package LeetCode.src.Explore.Interview.GoogleInterview.Recursion.WordSquares.Java;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    List<String> startWith;
    TrieNode[] children;

    TrieNode() {
        startWith = new ArrayList<>();
        children = new TrieNode[26];
    }
}