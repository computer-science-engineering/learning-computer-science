# Problem Definition

## Description

<https://leetcode.com/problems/jump-game-ii/>

## Discussion

### Approach

#### Time Complexity

#### Space Complexity

### Alternate Approach 1

#### Time Complexity - Alternate Approach 1

#### Space Complexity - Alternate Approach 1

## Notes

```java
public int jump(int[] arr) {
  if(arr.length <= 1) return 0;
  int last = 0;
  int jumps = 0;
  
  for(int i = 0 ; i < arr.length ; i++) {
    if(i > last) return -1;
    if(last == arr.length - 1) return jumps;
    last = Math.max(last, i + arr[i]);
    jumps++;
  }
  
  return -1;
}
```

## References
