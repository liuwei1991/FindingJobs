package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root ==null){
			return result;
		}
		Stack<TreeNode> q = new Stack<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		q.add(root);
		while(!q.isEmpty() || !s.isEmpty()){
			List<Integer> tmp = new ArrayList<Integer>();
			if(!q.isEmpty()){
				while(!q.isEmpty()){
					TreeNode current = q.pop();
					tmp.add(current.val);
					if(current.left!=null){
						s.add(current.left);
					}
					if(current.right!=null){
						s.add(current.right);
					}
				}
			}else{
				while(!s.isEmpty()){
					TreeNode current = s.pop();
					tmp.add(current.val);
					if(current.right!=null){
						q.add(current.right);
					}
					if(current.left!=null){
						q.add(current.left);
					}
				}
			}
			result.add(tmp);
		}
		
		return result;
    }
	
	public static void main(String[] args){
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = bt.new TreeNode(1);
		root.left = bt.new TreeNode(2);
		root.left.left = bt.new TreeNode(4);
		root.left.right = bt.new TreeNode(5);
		root.right = bt.new TreeNode(3);
//		root.right.left = bt.new TreeNode(6);
//		root.right.right= bt.new TreeNode(7);
		bt.zigzagLevelOrder(root);
	}
}
