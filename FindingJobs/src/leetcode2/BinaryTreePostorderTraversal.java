package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null){
			return result;
		}
		postOrder(root,result);
		return result;
	}
	
	public void postOrder(TreeNode root,List<Integer> result){
		if(root ==null){
			return;
		}
		postOrder(root.left,result);
		postOrder(root.right,result);
		result.add(root.val);
	}
}
