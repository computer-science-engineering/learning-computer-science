# Problem Definition

## Description

Design a data structure that supports the following two operations:

```text
void addWord(word)
bool search(word)
```

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

**Example:**

```text
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```

**Note:**
You may assume that all words are consist of lowercase letters `a-z`.

## Notes

1. [LeetCode discussion - Java Solution, easy understand](https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59669/Java-Solution-easy-understand)

    ```java
    Map<Integer, List<String>> wordsMap = new HashMap<>();
  
    public void AddWord(String word) {
        int index = word.length();
        if (wordsMap.contains(index)) {
        wordsMap.get(index).add(word);
        } else {
        List<String> words = new List<>();
        words.add(word);
        wordsMap.add(index, words);
        }
    }

    public bool SearchWord(String pattern) {
        int index = pattern.length();
        if (!wordsMap.containsKey(index)) {
        return false;
        }

        List<String> words = wordsMap.get(index);
        for(String word : words) {
        if (compare(word, pattern)) {
            return true;
        }
        }
        return false;
    }

    private boolean compare(String word, String pattern) {
        for (int i=0; i<word.length(); i++) {
        if (pattern.charAt(i) != '.' && word.charAt(i) != pattern.charAt(i)) {
            return false;
        }
        }
        return true;
    }
    ```

1. [LeetCode discussion - My simple and clean Java code](https://leetcode.com/problems/add-and-search-word-data-structure-design/discuss/59554/My-simple-and-clean-Java-code)