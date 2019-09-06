# Problem Definition

## Description

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

**Example:**

```plaintext
Input:  n = 2
Output: ["11","69","88","96"]
```

## Notes

1. [LeetCode discussion - AC clean Java solution](https://leetcode.com/explore/interview/card/google/62/recursion-4/399/discuss/67280/AC-clean-Java-solution)
1. [LeetCode discussion - Simple Java solution without recursion](https://leetcode.com/explore/interview/card/google/62/recursion-4/399/discuss/67288/Simple-Java-solution-without-recursion)

    ```java
    public List<String> findStrobogrammatic(int n) {
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;
        if(n%2 == 1)
            r = one;
        for(int i=(n%2)+2; i<=n; i+=2){
            List<String> newList = new ArrayList<>();
            for(String str : r){
                if(i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;
    }
    ```

1. LeetCode submission - 1 ms

    ```java
    private List<String> res = new ArrayList<>();
    private char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        backTrack(new char[n], 0, n - 1);
        return res;
    }

    private void backTrack(char[] arr, int start, int end) {
        if (start > end) {
            res.add(new String(arr));
            return;
        }
        for (char[] pair : pairs) {
            arr[start] = pair[0];
            arr[end] = pair[1];
            if (arr.length != 1 && arr[0] == '0') {
                continue;
            }
            if (start == end && pair[0] != pair[1]) {
                continue;
            }
            backTrack(arr, start + 1, end - 1);
        }
    }
    ```
