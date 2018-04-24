# Problem Definition

## Description

Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]

Return : [0, 1]

Lets say N = size of the array. Then, following holds true:

* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer

## Notes

1. [GfG problem](http://www.geeksforgeeks.org/rearrange-given-array-place/)

    ```text
    ex: arr[]={2,1,0};
    1st loop:
    arr[0]=arr[0]+(arr[arr[0]]%3)*3 = 2+(arr[2]%3)*3 = 2+(0%3)*3 = 2
    arr[1]=arr[1]+(arr[arr[1]]%3)*3 = 1+(arr[1]%3)*3 = 1+(1%3)*3 = 4
    arr[2]=arr[2]+(arr[arr[2]]%3)*3 = 0+(arr[0]%3)*3 = 0+(2%3)*3 = 6 // modulo needed to get original value of arr[0]
    2nd loop:
    arr[0]=arr[0]/3 = 2/3 = 0
    arr[1]=arr[1]/3 = 4/3 = 1
    arr[2]=arr[2]/3 = 6/3 = 2
    ```

1. [CareerCup post](https://www.careercup.com/question?id=4909367207919616)

    ```text
    (x + y*z)/z = y    provided x and y is less than z.
    (x + y*z)%z = x    provided x and y is less than z.
    This is the concept used here.
    Example:
    (3 + 4*5)/5 = 4
    (3 + 4*5)%5 = 3

    arr[i] = arr[i] + arr[arr[i]]*size
    so arr[i]/size = arr[arr[i]]

    In the code you see the author has used % below; this is done just to make sure arr[i] and arr[arr[i]] is less than size as explained earlier.
    arr[i] += (arr[arr[i]]%size)*size;
    ```