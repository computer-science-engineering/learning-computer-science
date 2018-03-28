package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Trie.ShortestUniquePrefix.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ArrayList<String> result = prefix(input);
        System.out.println(result);
        ArrayList<String> result_all = prefix_all(input);
        System.out.println(result_all);
        ArrayList<String> result_editorial = prefix_editorial(input);
        System.out.println(result_editorial);
    }
    
    private static final int MAX  = 256;
      
    // Maximum length of an input word
    private static final int MAX_WORD_LEN = 500;
      
    // Trie Node.
    private static class TrieNode {
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

    private static void searchPrefix(TrieNode root, String str, char[] prefix, int ind, StringBuilder result) {
        // Corner case
        if (root == null) {
            return;
         }
       
         // Base case
         if (root.freq == 1) {
            prefix[ind] = '\0';
            int i = 0;
            while(prefix[i] != '\0') {
                result.append(prefix[i++]);
            }
            return;
         }

         for (int i=0; i<MAX; i++) {
            if (root.child[i] != null) {
                if (str.charAt(0) == (char) i) {
                    prefix[ind] = (char) i;
                    String subStr = str.substring(1, str.length());
                    searchPrefix(root.child[i], subStr, prefix, ind+1, result);
                }
            }
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
        for (String str : A) {
            StringBuilder resultSb = new StringBuilder();
            searchPrefix(root, str, prefix, 0, resultSb);
            result.add(resultSb.toString());
        }
        return result;
    }

    public static ArrayList<String> prefix_all(ArrayList<String> A) {
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

    // Editorial solution

    public static ArrayList<String> prefix_editorial(ArrayList<String> a) {
	    TrieNode_editorial root_editorial = new TrieNode_editorial();
	    
	    for (String s : a) {
	        insert_editorial(root_editorial, s);
	    }
	    
	    ArrayList<String> prefixes = new ArrayList<>();
	    for (String s : a) {
	        prefixes.add(findPrefix_editorial(root_editorial, s));
	    }
	    
	    return prefixes;
	}
	
	private static void insert_editorial(TrieNode_editorial root_editorial, String s) {
	    TrieNode_editorial node = root_editorial;
	    
	    for (Character ch : s.toCharArray()) {
	        node = node.children.computeIfAbsent(ch, c -> new TrieNode_editorial());
	        node.count++;
	    }
	}
	
	private static String findPrefix_editorial(TrieNode_editorial root_editorial, String s) {
	    TrieNode_editorial node = root_editorial;
	    char[] chars = s.toCharArray();
	    int i = 0;
	    
	    StringBuilder prefix = new StringBuilder();
	    while (true) {
	        char ch = chars[i++];
	        
	        prefix.append(ch);
	        node = node.children.get(ch);
	        
	        if (node.count == 1) {
	            return prefix.toString();
	        }
	    }
	}
	
	static class TrieNode_editorial {
	    int count = 0;
	    Map<Character, TrieNode_editorial> children = new HashMap<>();
	}
}