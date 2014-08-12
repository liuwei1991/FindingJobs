package leetCode;

public class BalancedBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isBalanced(TreeNode root) {
        if(root==null){
        	return true;
        }
        if(this.depth(root)>0){
        	return true;
        }
        return false;
    }
	public int depth(TreeNode start){
		if(start == null) return 0;
		int left = depth(start.left);
		int right = depth(start.right);
		if(left<0 || right<0){
			return Integer.MIN_VALUE;
		}
		if(Math.abs(left-right)>1){
			return Integer.MIN_VALUE; 
		}
		return Math.max(left,right)+1;
	}
	
	public static void main(String[] args){
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode tr = bbt.new TreeNode(1);
		tr.left = bbt.new TreeNode(2);
		tr.left.left = bbt.new TreeNode(2);
		System.out.println(bbt.isBalanced(tr));
	}
}
