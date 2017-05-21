package leetCode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public void flatten(TreeNode root) {
		Stack<TreeNode> q = new Stack<TreeNode>();
		if(root==null){
			return;
		}
		q.add(root);
		TreeNode pre = null;
		while(!q.isEmpty()){
			TreeNode current =q.pop();
			if(pre!=null){
				pre.right=current;
				pre.left=null;
			}
			if(current.right!=null){
				q.add(current.right);
			}
			if(current.left!=null){
				q.add(current.left);
			}
			pre = current;
		}
    }
	public static void main(String[] args){
		FlattenBinaryTreetoLinkedList fb = new FlattenBinaryTreetoLinkedList();
		TreeNode tn =fb.new TreeNode(1);
//		 tn.left =fb.new TreeNode(2);
//		 tn.left.left =fb.new TreeNode(3);
//		 tn.left.right =fb.new TreeNode(4);
//		 tn.right =fb.new TreeNode(5);
//		 tn.right.right=fb.new TreeNode(6);
		 fb.flatten(tn);
	}
}
