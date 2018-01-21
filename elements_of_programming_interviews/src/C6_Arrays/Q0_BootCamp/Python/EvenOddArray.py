import sys
import random


def even_odd(a):
    next_even, next_odd = 0, len(a) - 1
    while next_even < next_odd:
        if a[next_even] % 2 == 0:
            next_even += 1
        else:
            temp = a[next_even]
            a[next_even] = a[next_odd]
            a[next_odd] = temp;
            next_odd -= 1


def main():
    for _ in range(10000):
        n = int(sys.argv[1]) if len(sys.argv) == 2 else random.randint(1, 20)
        a = [random.randint(0, 20) for _ in range(n)]
        even_odd(a)


if __name__ == '__main__':
    main()
