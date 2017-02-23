package astart.leetcode1;

public class SumofLeftLeaves {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isLeaves(TreeNode root){
		if(root==null){
			return true;
		}
		if(root.left==null && root.right==null){
			return true;
		}
		return false;
	}
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null){
			return 0;
		}
		int leftSum = 0;
		if(root.left!=null){
			if(isLeaves(root.left)){
				leftSum = root.left.val;
			}else{
				leftSum = sumOfLeftLeaves(root.left);
			}
		}
		int rightSum = 0;
		if(root.right!=null){
			rightSum = sumOfLeftLeaves(root.right);
		}
		return leftSum+rightSum;
	}
}
