package LeetCode.src.Explore.Interview.GoogleInterview.Design.ZigzagIterator.Java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    LinkedList<Iterator<Integer>> list;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator<Integer>>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public ZigzagIterator(List<List<Integer>> listOfLists) {
        list = new LinkedList<Iterator<Integer>>();
        for (List<Integer> listOfInt : listOfLists) {
            if (!listOfInt.isEmpty()) {
                list.add(listOfInt.iterator());
            }
        }
    }

    public int next() {
        Iterator<Integer> poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();        
    }
}