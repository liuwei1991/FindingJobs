package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
        	return result;
        }
        this.travel(root, result);
        return result;
    }
	
	public void travel(TreeNode root,List<Integer> r){
		if(root.left!=null){
			this.travel(root.left,r);
		}
		if(root.right!=null){
			this.travel(root.right, r);
		}
		r.add(root.val);
	}
}
