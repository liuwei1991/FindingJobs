package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x; 
		}
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    
		if(root == null){
	    	return result;
	    }
		this.solve(root, result);
	    return result;
	}
	
	public void solve(TreeNode tree, ArrayList<Integer> result){
		if(tree == null) return;
		TreeNode right = tree.right;
		TreeNode left = tree.left;
		tree.right = null;
		tree.left = null;
		result.add(tree.val);
		solve(left,result);
		solve(right,result);
	}
	
	public static void main(String[] args){
		BinaryTreePreorderTraversal btp = new BinaryTreePreorderTraversal();
		TreeNode root = btp.new TreeNode(1);
		root.left = btp.new TreeNode(2);
		root.left.left = btp.new TreeNode(4);
		root.right = btp.new TreeNode(3);
		root.right.left = btp.new TreeNode(5);
		root.right.right = btp.new TreeNode(6);
		root.right.right.left = btp.new TreeNode(8);
		root.right.left.right = btp.new TreeNode(7);
		for(int i:btp.preorderTraversal(root)){
			System.out.print(i+"  ");
		}
	}
}
