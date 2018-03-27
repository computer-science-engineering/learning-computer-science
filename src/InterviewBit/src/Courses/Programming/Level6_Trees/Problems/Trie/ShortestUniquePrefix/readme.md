# Problem Definition

## Description

Find shortest unique prefix to represent each word in the list.

Example:

```text
Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
```

**NOTE:** Assume that no word is prefix of another. In other words, the representation is always possible.

## Notes

1. [Geeks for Geeks - Find shortest unique prefix for every word in a given list | Set 1 (Using Trie)](https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/)

    A Simple Solution is to consider every prefix of every word (starting from the shortest to largest), and if a prefix is not prefix of any other string, then print it.

    An Efficient Solution is to use Trie. The idea is to maintain a count in every node. Below are steps.

    * Construct a [Trie](https://www.geeksforgeeks.org/trie-insert-and-search/) of all words. Also maintain frequency of every node (Here frequency is number of times node is visited during insertion). Time complexity of this step is O(N) where N is total number of characters in all words.
    * Now, for every word, we find the character nearest to the root with frequency as 1. The prefix of the word is path from root to this character. To do this, we can traverse Trie starting from root. For every node being traversed, we check its frequency. If frequency is one, we print all characters from root to this node and don’t traverse down this node.

    Time complexity if this step also is O(N) where N is total number of characters in all words.

    ```text
                        root
                        / \
                (d, 3)/    \(z, 1)
                    /       \
                Node1     Node2
                / \          \
          (o,2)/   \(u,1)     \(e,1)
              /     \          \
        Node1.1    Node1.2     Node2.1
            /  \         \            \
      (g,1)/    \ (t,1)   \(c,1)       \(b,1)
          /      \         \            \
        Leaf   Leaf       Node1.2.1     Node2.1.1
        (dog)  (dot)           \             \
                                \(k, 1)       \(r, 1)
                                 \             \
                                Leaf          Node2.1.1.1
                                (duck)             \
                                                    \(a,1)
                                                     \
                                                    Leaf
                                                    (zebra)
    ```