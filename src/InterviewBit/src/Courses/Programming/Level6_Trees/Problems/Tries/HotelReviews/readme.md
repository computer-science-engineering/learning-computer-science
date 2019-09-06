# Problem Definition

## Description

Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

*You are expected to use Trie in an Interview for such problems.*

**Constraints:**

```plaintext
1. 1 <= No.of reviews <= 200
2. 1 <= No. of words in a review <= 1000
3. 1 <= Length of an individual review <= 10,000
4. 1 <= Number of Good Words <= 10,000
5. 1 <= Length of an individual Good Word <= 4
6. All the alphabets are lower case (a - z)
```

**Input:**

```plaintext
S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
```

**Output:**

```plaintext
A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
```

**Example:**

```plaintext
Input:
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

**Output:**
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
```

## Notes

1. [Trie @ cs.bu.edu](https://www.cs.bu.edu/teaching/c/tree/trie/)
1. [Trie - Geeks for Geeks](https://www.geeksforgeeks.org/trie-insert-and-search/)
1. [GitHub - Olehka - HotelReviews.java](https://github.com/olehka/interviewbit/blob/master/src/Trees/HotelReviews.java)
1. [GitHub - Orina - HotelReviews.java](https://github.com/Orina/CodePathPrep/blob/b50c341fc76bfd55b05a2a6153b761a12ed8f7e5/src/week3/trees/HotelReviews.java)