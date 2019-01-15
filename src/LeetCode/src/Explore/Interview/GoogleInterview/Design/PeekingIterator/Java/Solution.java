package LeetCode.src.Explore.Interview.GoogleInterview.Design.PeekingIterator.Java;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIter = new PeekingIterator(iterator);
        assertEquals(peekingIter.next().intValue(), 1);
        assertEquals(peekingIter.peek().intValue(), 2);
        assertEquals(peekingIter.next().intValue(), 2);
        assertEquals(peekingIter.next().intValue(), 3);
        assertEquals(peekingIter.hasNext(), false);
    }
}