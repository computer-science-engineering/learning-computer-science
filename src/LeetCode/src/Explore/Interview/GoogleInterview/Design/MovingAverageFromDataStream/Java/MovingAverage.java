package LeetCode.src.Explore.Interview.GoogleInterview.Design.MovingAverageFromDataStream.Java;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    Queue<Integer> q;
    int capacity;
    int currSum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        capacity = size;
        currSum = 0;
    }
    
    public double next(int val) {
        currSum += val;
        q.offer(val);
        
        if(q.size() > capacity ) {
            currSum -= q.poll();
        }
       
        return currSum*1.0 / q.size() ;
    }
}