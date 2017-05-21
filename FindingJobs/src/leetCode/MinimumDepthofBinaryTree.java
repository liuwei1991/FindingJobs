package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int result = Integer.MAX_VALUE;
		if(root == null){
			return 0;
		}
		root.val=1;
		q.add(root);
		while(!q.isEmpty()){
			TreeNode tn = q.poll();
			if(tn.left ==null && tn.right==null){
				if(tn.val<result){
					result = tn.val;
				}
			}
			if(tn.right!=null){
				tn.right.val = tn.val+1;
				q.add(tn.right);
			}
			if(tn.left!=null){
				tn.left.val= tn.val+1;
				q.add(tn.left);
			}
		}
		return result;
    }
	
}
