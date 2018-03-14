# Problem Definition

## Description

You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.

Let's say:

* '(', '{', '[' are called "openers."
* ')', '}', ']' are called "closers."

Write an efficient method that tells us whether or not an input string's openers and closers are properly nested.

Examples:

* "{ [ ] ( ) }" should return true
* "{ [ ( ] ) }" should return false
* "{ [ }" should return false

### Gotchas

Simply making sure each opener has a corresponding closer is not enough—we must also confirm that they are correctly ordered.

For example, "{ [ ( ] ) }" should return false, even though each opener can be matched to a closer.

### Complexity

O(n)O(n) time (one iteration through the string), and O(n)O(n) space (in the worst case, all of our characters are openers, so we push them all onto the stack).

### Bonus

In Ruby, sometimes expressions are surrounded by vertical bars, "|like this|". Extend your validator to validate vertical bars. Careful: there's no difference between the "opener" and "closer" in this case—they're the same character!

### What We Learned

The trick was to use a stack.

It might have been difficult to have that insight, because you might not use stacks that much.

Two common uses for stacks are:

1. parsing (like in this problem)
1. tree or graph traversal (like depth-first traversal)

So remember, if you're doing either of those things, try using a stack!

## Notes