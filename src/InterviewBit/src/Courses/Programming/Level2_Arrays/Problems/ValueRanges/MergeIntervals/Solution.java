package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.ValueRanges.MergeIntervals;

import java.util.*;

public class Solution {
    public static void main(String[] args) { 
        System.out.println();
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 6));
        Interval newInterval = new Interval(1, 10);
        ArrayList<Interval> result = insert(input, newInterval);
        for(int i=0; i<result.size(); i++) { 
            String interval = "[" + result.get(i).start + "," + result.get(i).end + "]";
            System.out.print(interval + " " );
        }
    } 

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        if (intervals==null ||intervals.size()<2){
            return intervals;
        }

        ArrayList<Interval> result=new ArrayList<Interval>();        
        Comparator<Interval> intervalComparator=new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                Integer i1St=i1.start;
                Integer i2St=i2.start;
                return i1St.compareTo(i2St);                
            }
        };
        Collections.sort(intervals, intervalComparator);        
        Interval current=intervals.get(0);        
        int i=1;        
        while (i<intervals.size() ){
            Interval currentToCompare=intervals.get(i);
            if (current.end<currentToCompare.start){
                result.add(current);
                current=currentToCompare;                
            }
            else{
                current.end=Math.max(current.end, currentToCompare.end);                
            }
            i++;
        }        
        result.add(current);        
        return result;
    }

    // This approach uses stack
    public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        if(size == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        boolean inserted = false;
        for(int i=0;i<size;i++) {
            Interval iIter = intervals.get(i);
            if(iIter.start > newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }
        if(!inserted) {
            intervals.add(newInterval);
        }
        //merge and return
        return merge(intervals);
    }
    public ArrayList<Interval> merge(ArrayList<Interval> a) {
        Stack<Interval> st = new Stack<Interval>();
        st.push(a.get(0));
        for(int i=1;i<a.size();i++) {
            Interval top = st.peek();
            Interval iterInt = a.get(i);
            if(top.end>= iterInt.start) {
                Interval newInt = mergeIntervals(top, iterInt);
                st.pop();
                st.push(newInt);
            }
            else {
                st.push(iterInt);
            }
        }
        ArrayList<Interval> answer = new ArrayList<Interval>();
        while(!st.isEmpty()) {
           answer.add(st.pop());
        }
        Collections.reverse(answer);
        return answer;
    }
    public Interval mergeIntervals(Interval a ,Interval b) {
        int min = Math.min(a.start, b.start);
        int max = Math.max(a.end, b.end);
        return (new Interval(min, max));
    }
}