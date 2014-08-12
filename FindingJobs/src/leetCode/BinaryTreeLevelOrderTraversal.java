package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetCode.BinaryTreeLevelOrderTraversalII.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null) return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		q.add(root);
		int superStep = 1;
		
		int currentStep = 0;
		while (!q.isEmpty()) {
			currentStep = 0;
			tmp = new ArrayList<Integer>();
			for (int i = 0; i < superStep; i++) {
				TreeNode node = q.poll();
				tmp.add(node.val);
				if (node.left != null) {
					q.add(node.left);
					currentStep++;
				}
				if (node.right != null) {
					q.add(node.right);
					currentStep++;
				}
			}
			result.add(tmp);
			superStep = currentStep;
		}
		return result;
    }
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
		TreeNode tn =bt.new TreeNode(1);
		tn.right = bt.new TreeNode(20); 
		tn.left = bt.new TreeNode(9);
		tn.right.left = bt.new TreeNode(15); 
		tn.right.right = bt.new TreeNode(7); 
		bt.levelOrder(tn);
//		tn.right = bt.new TreeNode(20); 
	}
}
