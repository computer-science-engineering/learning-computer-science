# Problem Definition

## Description

Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal. Return both parts (If exist). If there is no solution. return an empty list.

**Example:**

```text
Input:
[1 7 15 29 11 9]

Output:
[9 15] [1 7 11 29]

The average of part is (15 + 9) / 2 = 12,
average of second part elements is (1 + 7 + 11 + 29) / 4 = 12
```

**NOTE 1:** If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition:

* numElements in A <= numElements in B
* If numElements in A = numElements in B, then A is [lexicographically](https://en.wikipedia.org/wiki/Lexicographical_order) smaller than B

**NOTE 2:** If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie, return the one where A is lexicographically smallest.

**NOTE 3:** Array will contain only non negative numbers.

## Notes

1. [Geeks for Geeks similar problem - Dynamic Programming | Set 18 (Partition problem)](https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/)
1. [Geeks for Geeks - Divide array into two sub-arrays such that their averages are equal](https://www.geeksforgeeks.org/divide-array-two-sub-arrays-averages-equal/)

    1. Compute sum of all array elements. Let this sum be "sum".
    1. Initialize leftSum = 0.
    1. Run a loop for i=0 to n-1.
        1. leftSum  = leftSum + arr[i]
        1. rightSum = sum - leftSum
        1. If average of left and right are same, print current index as output.

1. [KarmaAndCoding - Partition an array into 2 parts with equal average](https://karmaandcoding.blogspot.com/2012/01/partition-array-into-2-parts-with-equal.html)
1. [Quora - How would you divide an integer array into 2 sub-arrays such that their averages were equal?](https://www.quora.com/How-would-you-divide-an-integer-array-into-2-sub-arrays-such-that-their-averages-were-equal)
1. [GitHub - Ankur Kapoor](https://github.com/ankur-kapoor/Algos/blob/ab29a8e4392c011d8c28c9056a99ae81a3a28685/com/interviewbit/DP/AveragePartition.java)

### Hint and Solution Approach

Lets try to simplify the problem.

Lets assume the two sets are set1 and set2.

Assume sum of set1 = Sum_of_Set1, with size = size_of_set1.
Assume sum of set2 = Sum_of_Set2, with size = size_of_set2

```text
 SUM_of_Set1 / size_of_set1 = SUM_of_Set2 / size_of_set2
 SUM_of_Set1 = SUM_of_Set2 * (size_of_set1 / size_of_set2)

    total_sum = Sum_of_Set1 + Sum_of_Set2
    AND size_of_set2 = total_size - size_of_set1

  Sum_of_Set1 = (total_sum - Sum_of_Set1) * (size_of_set1 / (total_size - size_of_set1))
  OR on simplifying,

  total_sum / Sum_of_Set1 - 1 = (total_size - size_of_set1) / size_of_set1
  total_sum / Sum_of_Set1 = total_size / size_of_set1
  Sum_of_Set1 / size_of_set1 = total_sum / total_size
```

Note that you need the solution with minimum size_of_set1 if multiple solutions exist. 
So, just iterate on size_of_set1. 
Based on size_of_set1, you can determine the value of Sum_of_Set1. 
Now, the problem reduces to

```text
Can I select size_of_set1 values from the array whose sum is Sum_of_Set1/current_sum?
```

Lets define our function as `isPossible(ind, current_sum, current_size)` which returns true if it is possible to use elements with `index >= ind` to construct a set of size `current_size` whose sum is `current_sum`.

```text
isPossible(ind, current_sum, current_size :            |
                                                       |
                                                       |  isPossible(ind + 1, current_sum, current_size)  [ Do not include current element ]
                                Or(|) Logical operator |
                                                       |
                                                       |
                                                       |
                                                       |  isPossible(ind + 1, current_sum - value_at(ind), current_size - 1)
                                                       |
```

Can you memoize values to reduce the time complexity of the above recursive function ?