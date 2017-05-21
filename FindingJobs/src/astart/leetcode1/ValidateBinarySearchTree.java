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
		return this.solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	
	public boolean solve(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		if (root.left != null) {
			int val = root.left.val;
			if (val >= root.val || !this.solve(root.left, min, root.val)) {
				return false;
			}
		}
		if (root.right != null) {
			int val = root.right.val;
			if (val <= root.val || !this.solve(root.right, root.val, max)) {
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
