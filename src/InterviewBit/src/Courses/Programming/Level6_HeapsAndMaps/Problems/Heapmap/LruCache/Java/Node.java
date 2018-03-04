package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Heapmap.LruCache.Java;

class Node {
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}