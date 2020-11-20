# Problem Definition

## Description

Given a time series that keeps information about temperature readings for a city, return a time series that tells you, for a given day, how long has its value been the largest running value.

For example, for temperature readings [3, 5, 6, 2, 1, 4, 6, 9], the transformed time series would be [1, 2, 3, 1, 1, 3, 7, 8]

```plaintext
input: [3, 5, 6, 2, 1, 4, 6, 9]
output: [1, 2, 3, 1, 1, 3, 7, 8]
```

- we need a running count of how many days we've seen
- we need to know what's the largest number we've seen so far
- we also need to know how many days it would have been the maximum

## Discussion

### Approach

#### Time Complexity

#### Space Complexity

### Alternate Approach 1

#### Time Complexity - Alternate Approach 1

#### Space Complexity - Alternate Approach 1

## Notes

```python
import logging

def get_max(input_list):
  output_list = []

  for ele_pos, ele in enumerate(input_list):
    max_ele_count = 1
    for prev_ele_pos in range(ele_pos-1, -1, -1):  # right-end is exclusive, so +1
      print(f"looking at {input_list[ele_pos]}, {input_list[prev_ele_pos]}")
      if input_list[ele_pos] >= input_list[prev_ele_pos]:
        print(f"incrementing count: {max_ele_count}")
        max_ele_count += 1
      else:
        print("breaking out")
        break
    output_list.append(max_ele_count)
  
  print(output_list)  
  return output_list
  
def test_get_max():
  input_list = [3, 5, 6, 2, 1, 4, 6, 9]
  assert get_max(input_list) == [1, 2, 3, 1, 1, 3, 7, 8], "Test failed"

test_get_max()
```

```java
import java.io.*;

class MyCode {
  public static void main (String[] args) {
    System.out.println("Hello Java");
  }
  
  public static class Pair {
    int offset;
    //int maxValue
  }
  
  class Node {
    Node next;
    Node prev;
    int offset;
  }
  public static int[] transform(int[] a) {
    final int[] result = new int[a.length];

    Node tail = null;

    int i = 0;
    int max = Integer.MIN_VALUE;
    while (i < a.length) {
      if (tail == null) {
        result[i] = 1;
      }
      if (max <= a[i]) {

      } else {
        if (tail == null) {
          tail = new Node(i-1);
        } else {
          Node n = new Node(i-1);
          tail.next = n;
          n.prev = tail;
          tail = n;
        }
      }
    }
  }
}
```

## References
