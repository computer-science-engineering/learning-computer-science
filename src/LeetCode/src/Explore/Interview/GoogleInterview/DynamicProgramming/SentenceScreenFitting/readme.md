# Problem Definition

## Description

Given a `rows x cols` screen and a sentence represented by a list of **non-empty** words, find **how many times** the given sentence can be fitted on the screen.

**Note:**

1. A word cannot be split into two lines.
2. The order of words in the sentence must remain unchanged.
3. Two consecutive words **in a line** must be separated by a single space.
4. Total words in the sentence won't exceed 100.
5. Length of each word is greater than 0 and won't exceed 10.
6. 1 ≤ rows, cols ≤ 20,000.

**Example 1:**

```plaintext
Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
```

**Example 2:**

```plaintext
Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output:
2

Explanation:
a-bcd-
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
```

**Example 3:**

```plaintext
Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output:
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
```

## Notes

1. [YT Video - Making Algorithms Simpler - MAS - Sentence Screen Fitting | Dynamic Programming | Python](https://www.youtube.com/watch?v=x4H-bXmNUfQ)
1. [LeetCode discussion - 21ms 18 lines Java solution](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90845/21ms-18-lines-Java-solution)

    ```java
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / s.length();
    }
    ```

    [Explanation](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90845/21ms-18-lines-Java-solution/95293)
    1. `String s = String.join(" ", sentence) + " " ;`. This line gives us a formatted sentence to be put to our screen.
    2. `start` is the counter for how many valid characters from s have been put to our screen.
    3. `if (s.charAt(start % l) == ' ')` is the situation that we don't need an extra space for current row. The current row could be successfully fitted. So that we need to increase our counter by using start++.
    4. The `else` is the situation, which the next word can't fit to current row. So that we need to remove extra characters from next word.
    5. `start / s.length()` is `(# of valid characters) / our formatted sentence`.

    [Optimized to 12ms. O(m + n), m: length of sentence by char, n: rows.](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90845/21ms-18-lines-Java-solution/95290)

    ```java
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }
    ```

1. [LeetCode discussion - 12ms Java solution using DP](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90874/12ms-Java-solution-using-DP)
1. [LeetCode discussion - Java, 10ms, starting with 12ms-java-solution-using-dp but then using a binary progression](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90856/Java-10ms-starting-with-12ms-java-solution-using-dp-but-then-using-a-binary-progression)
1. [LeetCode discussion - JAVA optimized solution 17ms](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/356/discuss/90846/JAVA-optimized-solution-17ms)