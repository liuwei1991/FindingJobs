package astart.leetcode1;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int result = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root==null){
			return 0;
		}
		this.solve(root);
		return result;
	}
	
	public int solve(TreeNode node){
		if(node==null){
			return Integer.MIN_VALUE;
		}
		int left = this.solve(node.left);
		int right = this.solve(node.right);
		int curMax = Math.max(left, right);
		if(curMax<0){
			result = Math.max(result, node.val);
			return node.val;
		}else{
			curMax = Math.max(curMax, curMax+node.val);
			curMax = Math.max(curMax, node.val);
			curMax = Math.max(curMax, node.val+left+right);
			result = Math.max(result, curMax);
			return Math.max(Math.max(left, right)+node.val,node.val);
		}
	}
}
