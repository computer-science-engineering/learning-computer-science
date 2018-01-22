package HackerRank.src.Tutorials.ThirtyDaysOfCode.D23_BSTLevelOrderTraversal;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hello World");
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
        sc.close();
    }

    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() != 0){
            Node tree = queue.remove();

            if(tree.left != null){
                queue.add(tree.left);
            }

            if (tree.right != null){
                queue.add(tree.right);
            }

            System.out.print(tree.data + " ");
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
}

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
