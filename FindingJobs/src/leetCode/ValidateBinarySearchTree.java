package leetCode;

import java.util.LinkedList;
import java.util.Queue;
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
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		this.genInorder(q, root);
		TreeNode pre = q.poll();
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur.val <= pre.val) {
				return false;
			}
			pre = cur;
		}
		return true;
	}

	public void genInorder(Queue<TreeNode> result, TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			this.genInorder(result, root.left);
		}
		result.add(root);
		if (root.right != null) {
			this.genInorder(result, root.right);
		}
	}
	public static void main(String[] args){
		ValidateBinarySearchTree vb = new ValidateBinarySearchTree();
		TreeNode root = vb.new TreeNode(1);
		root.left = vb.new TreeNode(-1);
		System.out.println(vb.isValidBST(root));
	}
}
