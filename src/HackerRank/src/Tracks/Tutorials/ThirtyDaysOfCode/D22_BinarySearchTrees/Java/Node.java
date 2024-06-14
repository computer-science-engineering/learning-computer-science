package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D22_BinarySearchTrees.Java;

public class Node{
        Node left,right;
        int data;
        Node(){
        }

        Node(int data){
            this.data=data;
            left=right=null;
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

    public static int getHeight(Node root){
        if (root == null){
            return -1;
        }
        else {
            return 1+ Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
}

