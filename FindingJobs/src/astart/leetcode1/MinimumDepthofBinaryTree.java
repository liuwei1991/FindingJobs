package astart.leetcode1;

public class MinimumDepthofBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int result = Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		this.solve(root,0);
		return result;
	}
	
	public void solve(TreeNode root,int depth){
		if(root.left==null&&root.right ==null){
			result = Math.min(result, depth+1);
		}
		if(root.left!=null){
			this.solve(root.left, depth+1);
		}
		if(root.right!=null){
			this.solve(root.right, depth+1);
		}
	}

}
