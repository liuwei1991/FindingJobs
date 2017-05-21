package astart.leetcode1;

public class SumRoottoLeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	private int result = 0;
	public int sumNumbers(TreeNode root) {
		if(root==null){
			return 0;
		}
        this.solve(root, 0);
        return result;
    }
	public void solve(TreeNode root,int before){
		if(root==null){
			return;
		}
		if(root.left==null && root.right==null){
			result += before*10+root.val;
			return;
		}
		this.solve(root.left, before*10+root.val);
		this.solve(root.right, before*10+root.val);
	}
}
