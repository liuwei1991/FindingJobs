package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		List<Integer> size = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<TreeNode> tn = new Stack<TreeNode>();

		q.add(root);
		tn.add(root);
		int superStep = 1;
		size.add(1);
		int currentStep = 0;
		while (!q.isEmpty()) {
			currentStep = 0;
			for (int i = 0; i < superStep; i++) {
				TreeNode node = q.poll();
				if (node.right != null) {
					q.add(node.right);
					tn.add(node.right);
					currentStep++;
				}
				if (node.left != null) {
					q.add(node.left);
					tn.add(node.left);
					currentStep++;
				}
			}
			superStep = currentStep;
			if (superStep != 0) {
				size.add(superStep);
			}
		}

		for (int i = size.size() - 1; i >= 0; i--) {
			List<Integer> tmp = new ArrayList<Integer>();
			for (int j = 0; j < size.get(i); j++) {
				tmp.add(tn.pop().val);
			}
			result.add(tmp);
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII bt = new BinaryTreeLevelOrderTraversalII();
		TreeNode tn =bt.new TreeNode(1);
//		tn.right = bt.new TreeNode(20); 
//		tn.left = bt.new TreeNode(9);
//		tn.right.left = bt.new TreeNode(15); 
//		tn.right.right = bt.new TreeNode(7); 
		bt.levelOrderBottom(tn);
//		tn.right = bt.new TreeNode(20); 
	}
}
