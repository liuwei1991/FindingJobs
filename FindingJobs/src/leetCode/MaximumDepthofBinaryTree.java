package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if(root == null) return 0;
		q.add(root);
		int depth = 0;
		int superStep = 1;
		int thisStep = 0;
		while(!q.isEmpty()){
			thisStep = 0;
			for(int i=0;i<superStep;i++){
				TreeNode tn = q.poll();
				if(tn.left!=null){
					q.add(tn.left);
					thisStep++;
				}
				if(tn.right!=null){
					q.add(tn.right);
					thisStep++;
				}
			}
			superStep = thisStep;
			depth++;
		}
		return depth;
	}
	
}
