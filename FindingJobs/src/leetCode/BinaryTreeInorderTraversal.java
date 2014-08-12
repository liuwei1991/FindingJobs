package leetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	private List<Integer> inorder = new ArrayList<Integer>();
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return inorder;
        if(root.left!=null){
        	inorderTraversal(root.left);
        }
        this.inorder.add(root.val);
        if(root.right!=null){
        	inorderTraversal(root.right);
        }
        return this.inorder;
    }
}
