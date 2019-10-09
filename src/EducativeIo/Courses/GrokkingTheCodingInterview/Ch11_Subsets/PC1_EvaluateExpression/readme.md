# Problem Definition

## Description

Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.

Example 1:

```plaintext
Input: "1+2*3"
Output: 7, 9
Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
```

Example 2:

```plaintext
Input: "2*3-4-5"
Output: 8, -12, 7, -7, -3
Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => 8
```

## Discussion

This problem follows the **Subsets** pattern and can be mapped to **Balanced Parentheses**. We can follow a similar **BFS** approach.

Let’s take Example-1 mentioned above to generate different ways to evaluate the expression.

1. We can iterate through the expression character-by-character.
2. we can break the expression into two halves whenever we get an operator (+, -, *).
3. The two parts can be calculated by recursively calling the function.
4. Once we have the evaluation results from the left and right halves, we can combine them to produce all results.

### Time Complexity

### Space Complexity

## Notes

## References
