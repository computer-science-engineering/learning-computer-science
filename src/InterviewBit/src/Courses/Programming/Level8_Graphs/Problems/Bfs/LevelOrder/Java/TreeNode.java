package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.Bfs.LevelOrder.Java;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
        val = x; 
    }

	/*
	int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
		TreeNode a = TreeNode.fromArray(values);
	*/
    public static TreeNode fromArray(int[] nodeValues) {
		TreeNode root = null;
		
		if (nodeValues.length > 0) {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			
			for (int i = 0; i < nodeValues.length; i++) {
				TreeNode node = null;
				
				int nodeVal = nodeValues[i];
				if (nodeVal != -1) {
					node = new TreeNode(nodeVal);
					
					if (i > 0) {
						int parent = i / 2;
						
						boolean left = (i%2) > 0;

						if (left) {
							TreeNode parentNode = nodes.get(parent);
							parentNode.left = node;
						} else {
							parent -= 1;
							TreeNode parentNode = nodes.get(parent);
							parentNode.right = node;
						}
					}
				}
				
				nodes.add(node);
			}
			
			root = nodes.get(0);
		}
		
        return root;
    }
}