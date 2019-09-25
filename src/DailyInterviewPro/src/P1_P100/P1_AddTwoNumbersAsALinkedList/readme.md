# Problem Definition

## Description

You are given two linked-lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Example:

```plaintext
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

Here is the function signature as a starting point (in Python):

```python
# Definition for singly-linked list.
class ListNode(object):
  def __init__(self, x):
    self.val = x
    self.next = None

class Solution:
  def addTwoNumbers(self, l1, l2, c = 0):
    # Fill this in.

l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)

l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(4)

result = Solution().addTwoNumbers(l1, l2)
while result:
  print result.val,
  result = result.next
# 7 0 8
```

## Discussion

### Time Complexity

### Space Complexity

## Notes

## References

1. [LeetCode discussion - Is this Algorithm optimal or what?](https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what)

    ```java
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.value;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.value;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }
    ```

2. [LeetCode discussion - My accepted Java solution](https://leetcode.com/problems/add-two-numbers/discuss/1059/My-accepted-Java-solution)

    ```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode prev = new ListNode(0);
      ListNode head = prev;
      int carry = 0;
      while (l1 != null || l2 != null || carry != 0) {
          ListNode cur = new ListNode(0);
          int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
          cur.val = sum % 10;
          carry = sum / 10;
          prev.next = cur;
          prev = cur;

          l1 = (l1 == null) ? l1 : l1.next;
          l2 = (l2 == null) ? l2 : l2.next;
      }
      return head.next;
    }
    ```

3. [LeetCode solution](https://leetcode.com/problems/add-two-numbers/solution/)

    ```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0);
      ListNode p = l1, q = l2, curr = dummyHead;
      int carry = 0;
      while (p != null || q != null) {
          int x = (p != null) ? p.val : 0;
          int y = (q != null) ? q.val : 0;
          int sum = carry + x + y;
          carry = sum / 10;
          curr.next = new ListNode(sum % 10);
          curr = curr.next;
          if (p != null) p = p.next;
          if (q != null) q = q.next;
      }
      if (carry > 0) {
          curr.next = new ListNode(carry);
      }
      return dummyHead.next;
    }
    ```
