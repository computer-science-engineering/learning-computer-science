# Problem Definition

## Description

Given an Iterator class interface with methods: _next()_ and _hasNext()_, design and implement a PeekingIterator that support the _peek()_ operation -- it essentially peek() at the element that will be returned by the next call to next().

**Example:**

```text
Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
```

**Follow up:** How would you extend your design to be generic and work with all types, not just integer?

## Notes

1. [LeetCode discussion - Concise Java Solution](https://leetcode.com/explore/interview/card/google/65/design-4/343/discuss/72558/Concise-Java-Solution)
1. [LeetCode discussion - Why Java generics aren't acceptable for the followup ?](https://leetcode.com/explore/interview/card/google/65/design-4/343/discuss/115636/Why-Java-generics-aren't-acceptable-for-the-followup)

    ```java
    class PeekingIterator<E> implements Iterator<E> {
        Iterator<E> itr;
        E nextElem;
        boolean hasNextElem;

        public PeekingIterator(Iterator<E> iterator) {
            this.itr = iterator;
            this.nextElem = iterator.next();
            this.hasNextElem = true;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public E peek() {
            return nextElem;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public E next() {
            if (!hasNextElem)
                throw new RuntimeException();
            E ret = nextElem;
            if (itr.hasNext()) nextElem = itr.next();
            else hasNextElem = false;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return hasNextElem;
        }
    }
    ```

1. LeetCode sample submission - 58 ms

    ```java
    import java.util.NoSuchElementException;

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {
        Integer nextVal;
        Iterator<Integer> iter;
        public PeekingIterator(Iterator<Integer> iterator) {
            this.iter = iterator;
            if (iter != null && iter.hasNext()) {
                nextVal = iter.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextVal;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (nextVal == null) throw new NoSuchElementException();
            Integer result = nextVal;
            nextVal = iter.hasNext()?iter.next():null;
            return result;
        }

        @Override
        public boolean hasNext() {
            return nextVal != null;
        }
    }
    ```