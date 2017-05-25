package astart.leetcode1;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}
		return this.solve(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}
	
	public boolean solve(TreeNode node,long max,long min){
		if(node.val<=min || node.val>=max){
			return false;
		}
		if(node.left!=null){
			if(!this.solve(node.left,node.val, min)){
				return false;
			}
		}
		if(node.right!=null){
			if(!this.solve(node.right,max, node.val)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		ValidateBinarySearchTree t= new ValidateBinarySearchTree();
		TreeNode root = t.new TreeNode(2);
		root.left = t.new TreeNode(1);
		root.right = t.new TreeNode(3);
		System.out.println(t.isValidBST(root));
	}
}
