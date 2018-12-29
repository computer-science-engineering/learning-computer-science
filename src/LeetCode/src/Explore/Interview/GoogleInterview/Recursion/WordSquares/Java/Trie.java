package LeetCode.src.Explore.Interview.GoogleInterview.Recursion.WordSquares.Java;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;

    Trie(String[] words) {
        root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur.children[idx].startWith.add(w);
                cur = cur.children[idx];
            }
        }
    }

    List<String> findByPrefix(String prefix) {
        List<String> ans = new ArrayList<>();
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null)
                return ans;

            cur = cur.children[idx];
        }
        ans.addAll(cur.startWith);
        return ans;
    }
}