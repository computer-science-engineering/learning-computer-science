package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.ShortestPath.WordLadder1.Java;

public class WordNode {
    String word;
    int numSteps;
    WordNode pre;
    public WordNode(String word, int numSteps, WordNode pre) {
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
     public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;        
    }
}