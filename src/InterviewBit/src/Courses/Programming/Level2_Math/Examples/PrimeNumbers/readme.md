# Problem Definition

## Description

Given a number N, find all prime numbers up to N ( N included ).

Example:

if N = 7,

all primes till 7 = {2, 3, 5, 7}

Make sure the returned array is sorted.

## Notes

1. [Geeks for Geeks - Sieve of Eratosthenes](https://www.geeksforgeeks.org/sieve-of-eratosthenes/)

    Following is the algorithm to find all the prime numbers less than or equal to a given integer n by Eratosthenes’ method:

    * Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
    * Initially, let p equal 2, the first prime number.
    * Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list. These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked.
    * Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.

    When the algorithm terminates, all the numbers in the list that are not marked are prime.