package astart.leetcode1;

public class InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.right);
		invertTree(root.left);
		TreeNode tmp = root.left;
		
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}
