# Problem Definition

## Description

Merge *k* sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

```plaintext
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/merge-k-sorted-lists/solution/)
1. [LeetCode discussion - A java solution based on Priority Queue](https://leetcode.com/explore/interview/card/google/60/linked-list-5/342/discuss/10528/A-java-solution-based-on-Priority-Queue)
1. [LeetCode discussion - My simple java Solution use recursion](https://leetcode.com/explore/interview/card/google/60/linked-list-5/342/10522/My-simple-java-Solution-use-recursion)
1. [Geeks for Geeks - Merge K sorted linked lists | Set 1](https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/)
1. [Geeks for Geeks - Merge k sorted arrays | Set 1](https://www.geeksforgeeks.org/merge-k-sorted-arrays/)
1. [yusun blog](https://yusun2015.wordpress.com/2015/01/16/merge-k-sorted-lists/)

    * use a heap and put all the nodes in the heap.
    * insert the node on the top of the head to the list and put the node.next into the heap.
    * if we have total n nodes and k sorted list, then the complexity is O(long(k)).

    ```java
    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if(n1.val > n2.val) return 1;
                    if(n1.val == n2.val) return 0;
                    return -1;
                }
            });
        for(ListNode node:a) {
            if(node != null) {
                q.add(node);
            }
        }
        while(!q.isEmpty()) {
            ListNode temp = q.remove();
            pre.next = temp;
            pre = temp;
            if(temp.next != null) {
                q.add(temp.next);
            }
        }
        return head.next;
    }
    ```

1. LeetCode top submission - 5ms solution.

    ```java
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists,0,lists.length-1);
    }

    public ListNode partition(ListNode[] lists, int left, int right){
        if (left==right) return lists[left];
        if (left<right){
            int mid = (right+left)/2;
            ListNode l1 = partition(lists,left,mid);
            ListNode l2 = partition(lists,mid+1,right);
            return merge(l1,l2);
        }
        return null;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l2.next,l1);
            return l2;
        }
    }
    ```

### Solution Approach

There are 2 approaches to solving the problem.

Approach 1 - Using heap: At every instant, you need the minimum of the head of all the k linked list. Once you know the minimum, you can push the node to your answer list, and move over to the next node in that linked list.

Approach 2 - Divide and conquer: Solve the problem for first k/2 and last k/2 list. Then you have 2 sorted lists. Then simply merge the lists. Time complexity:

```plaintext
T(N) = 2 T(N/2) + N
T(N) = O (N log N)
```