package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Trie.ShortestUniquePrefix.Java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ArrayList<String> result = prefix(input);
        System.out.println(result);
    }
    
    private static final int MAX  = 256;
      
    // Maximum length of an input word
    private static final int MAX_WORD_LEN = 500;
      
    // Trie Node.
    private static class TrieNode
    {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency
        TrieNode() {
            freq = 1;
            for (int i = 0; i < MAX; i++) {
                child[i] = null;
            }
        }
    }

    private static TrieNode root;

    // Method to insert a new string into Trie
    private static void insert(String str) {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;
    
        // Traversing over the length of given str.
        for (int level = 0; level<len; level++) {
            // Get index of child node from current character in str.
            int index = str.charAt(level);
    
            // Create a new child if not exist already
            if (pCrawl.child[index] == null) {
                pCrawl.child[index] = new TrieNode();
            }
            else {
                (pCrawl.child[index].freq)++;
            }
    
            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }

     // This function prints unique prefix for every word stored
    // in Trie. Prefixes one by one are stored in prefix[].
    // 'ind' is current index of prefix[]
    private static void findPrefixesUtil(TrieNode root, char[] prefix, int ind, ArrayList<String> result) {        
        StringBuilder sb = new StringBuilder();
        // Corner case
        if (root == null) {
           return;
        }
      
        // Base case
        if (root.freq == 1) {
           prefix[ind] = '\0';
           int i = 0;
           while(prefix[i] != '\0') {
               sb.append(prefix[i++]);
               //System.out.print(prefix[i++]);
           }
           result.add(sb.toString());
           //System.out.print("  ");
           return;
        }
      
        for (int i=0; i<MAX; i++) {
           if (root.child[i] != null) {
               prefix[ind] = (char) i;
               findPrefixesUtil(root.child[i], prefix, ind+1, result);
           }
        }
    }

    public static ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<String>();
        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i<A.size(); i++) {
            insert(A.get(i));
        }
      
        // Create an array to store all prefixes
        char[] prefix = new char[MAX_WORD_LEN];
         
        // Find all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0, result);
        return result;
    }
}