package leetCode;

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return this.isSymmetricTree(root.left, root.right);
    }
	
	public boolean isSymmetricTree(TreeNode left,TreeNode right){
		if(left==null && right ==null){
			return true;
		}else if(left==null || right ==null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}
		if(this.isSymmetricTree(left.left, right.right) && this.isSymmetricTree(left.right, right.left)){
			return true;
		}
		return false;
	}
}
