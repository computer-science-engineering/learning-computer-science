# Problem Definition

## Description

Write a function to find the 2nd largest element in a binary search tree.

Here's a sample binary tree node class:

```java
  public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
```

### Gotchas

Our first thought might be to do an in-order traversal of the BST and return the second-to-last item. This means looking at every node in the BST. That would take `O(n)` time and `O(h)` space, where `h` is the max height of the tree (which is `lg(n)` if the tree is balanced, but could be as much as `n` if not).

We can do better than `O(n)` time and `O(h)` space.

We can do this in one walk from top to bottom of our BST. This means `O(h)` time (again, that's `O(lg n)` if the tree is balanced, `O(n)` otherwise).

A clean recursive implementation will take `O(h)` space in the call stack, ↴ but we can bring our algorithm down to `O(1)` space overall.

### Breakdown

Let's start by solving a simplified version of the problem and see if we can adapt our approach from there. **How would we find the largest element in a BST?**

A reasonable guess is to say **the largest element is simply the "rightmost" element**.

So maybe we can start from the root and just step down right child pointers until we can't anymore (until the right child is null). At that point the current node is the largest in the whole tree.

Is this sufficient? We can prove it is by contradiction:

If the largest element were not the "rightmost," then the largest element would either:

1. be in some ancestor node's left subtree, or
1. have a right child.

But each of these leads to a contradiction:

1. If the node is in some ancestor node's left subtree it's smaller than that ancestor node, so it's not the largest.
1. If the node has a right child that child is larger than it, so it's not the largest.

So the "rightmost" element must be the largest.

**How would we formalize getting the "rightmost" element in code?**

We can use a simple recursive approach. At each step:

1. If there is a right child, that node and the subtree below it are all greater than the current node. So step down to this child and recurse.
1. Else there is no right child and we're already at the "rightmost" element, so we return its value.

```java
  public static int findLargest(BinaryTreeNode rootNode) {
    if (rootNode.right != null) {
        return findLargest(rootNode.right);
    }
    return rootNode.value;
}
```

Okay, so we can find the largest element. **How can we adapt this approach to find the second largest element?**

Our first thought might be, "it's simply the parent of the largest element!" That seems obviously true when we imagine a nicely balanced tree like this one:

```text
.        ( 5 )
        /     \
      (3)     (8)
     /  \     /  \
   (1)  (4) (7)  (9)
```

But what if the largest element itself has a left subtree?

```text
.        ( 5 )
        /     \
      (3)     (8)
     /  \     /  \
   (1)  (4) (7)  (12)
                 /
               (10)
               /  \
             (9)  (11)
```

Here the parent of our largest is 8, but the second largest is 11.

Drat, okay so the second largest isn't necessarily the parent of the largest...back to the drawing board...

Wait. No. The second largest is the parent of the largest if the largest does not have a left subtree. If we can handle the case where the largest does have a left subtree, we can handle all cases, and we have a solution.

So let's try sticking with this. **How do we find the second largest when the largest has a left subtree?**

**It's the largest item in that *left* subtree!** Whoa, we freaking just wrote a method for finding the largest element in a tree. We could use that here!

### Complexity

We're doing one walk down our BST, which means `O(h)` time, where hh is the height of the tree (again, that's `O(lg n)` if the tree is balanced, `O(n)` otherwise). `O(1)` space.

### What We Learned

Here we used a **"simplify, solve, and adapt"** strategy.

The question asks for a method to find the second largest element in a BST, so we started off by simplifying the problem: we thought about how to find the first largest element.

Once we had a strategy for that, we adapted that strategy to work for finding the second largest element.

It may seem counter-intuitive to start off by solving the wrong question. But starting off with a simpler version of the problem is often much faster, because it's easier to wrap our heads around right away.

One more note about this one:

Breaking things down into cases is another strategy that really helped us here.

Notice how simple finding the second largest node got when we divided it into two cases:

1. The largest node has a left subtree.
1. The largest node does not have a left subtree.

Whenever a problem is starting to feel complicated, try breaking it down into cases.

It can be really helpful to actually draw out sample inputs for those cases. This will keep your thinking organized and also help get your interviewer on the same page.

## Notes