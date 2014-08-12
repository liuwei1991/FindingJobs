package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SumRoottoLeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int sumNumbers(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null){
        	return 0;
        }
        int result = 0;
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode current = q.poll();
        	if(current.left==null && current.right==null){
        		result+=current.val;
        	}
        	if(current.left!=null){
        		current.left.val += 10*current.val;
        		q.add(current.left);
        	}
        	if(current.right!=null){
        		current.right.val+=10*current.val;
        		q.add(current.right);
        	}
        }
        return result;
    }
}
