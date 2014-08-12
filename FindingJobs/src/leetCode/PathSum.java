package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null){
        	return false;
        }
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode current = q.poll();
        	if(current.right!=null){
        		current.right.val += current.val;
        		q.add(current.right);
        	}
        	if(current.left!=null){
        		current.left.val += current.val;
        		q.add(current.left);
        	}
        	if(current.left==null && current.right==null){
        		if(current.val == sum){
        			return true;
        		}
        	}
        }
        return false;
    }
}
