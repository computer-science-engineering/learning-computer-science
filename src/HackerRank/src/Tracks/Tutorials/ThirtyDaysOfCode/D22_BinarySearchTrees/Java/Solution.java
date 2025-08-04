package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D22_BinarySearchTrees.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Node node = new Node();
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=node.insert(root,data);
        }
        int height=node.getHeight(root);
        System.out.println(height);
        sc.close();
    }
}

