# Problem Definition

## Description

Design a max stack that supports push, pop, top, peekMax and popMax.

1. push(x) -- Push element x onto stack.
2. pop() -- Remove the element on top of the stack and return it.
3. top() -- Get the element on the top.
4. peekMax() -- Retrieve the maximum element in the stack.
5. popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

**Example 1:**

```text
MaxStack stack = new MaxStack();
stack.push(5);
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
```

**Note:**

1. -1e7 <= x <= 1e7
2. Number of operations won't exceed 10000.
3. The last four operations won't be called when stack is empty.

## Notes

1. [LeetCode discussion - Java AC solution](https://leetcode.com/problems/max-stack/discuss/108938/Java-AC-solution)
1. [LeetCode article](https://leetcode.com/articles/max-stack/)

    ```java
    class MaxStack {
        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList dll;

        public MaxStack() {
            map = new TreeMap();
            dll = new DoubleLinkedList();
        }

        public void push(int x) {
            Node node = dll.add(x);
            if(!map.containsKey(x))
                map.put(x, new ArrayList<Node>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = dll.pop();
            List<Node> L = map.get(val);
            L.remove(L.size() - 1);
            if (L.isEmpty()) map.remove(val);
            return val;
        }

        public int top() {
            return dll.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = peekMax();
            List<Node> L = map.get(max);
            Node node = L.remove(L.size() - 1);
            dll.unlink(node);
            if (L.isEmpty()) map.remove(max);
            return max;
        }
    }

    class DoubleLinkedList {
        Node head, tail;

        public DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node x = new Node(val);
            x.next = tail;
            x.prev = tail.prev;
            tail.prev = tail.prev.next = x;
            return x;
        }

        public int pop() {
            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    class Node {
        int val;
        Node prev, next;
        public Node(int v) {val = v;}
    }
    ```