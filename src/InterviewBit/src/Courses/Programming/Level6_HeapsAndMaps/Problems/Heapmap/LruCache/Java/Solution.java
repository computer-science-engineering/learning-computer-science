package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Heapmap.LruCache.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution(2);
        solution.set(1, 10);
        solution.set(5, 12);
        System.out.println(solution.get(5));
        System.out.println(solution.get(1));
        System.out.println(solution.get(10));
        solution.set(6, 14);
        System.out.println(solution.get(5));
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;
    
    public Solution(int capacity) {
        this.capacity = capacity;        
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        } 
        return -1;
    }
    
    public void remove(Node n){
        if(n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
 
        if(n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        } 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head != null) {
            head.pre = n;
        }
 
        head = n;
 
        if(end == null) {
            end = head;
        }
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created); 
            } else {
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }    
}