package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if(root==null){
			return;
		}
		List<TreeNode> result = new ArrayList<TreeNode>();
		this.dfs(root, result);
		TreeNode cur = root;
		for(int i=1;i<result.size();i++){
			cur.left=null;
			cur.right = result.get(i);
			cur = cur.right;
		}
	}
	
	public void dfs(TreeNode root,List<TreeNode> result){
		if(root==null){
			return;
		}
		result.add(root);
		if(root.left!=null){
			this.dfs(root.left, result);
		}
		if(root.right!=null){
			this.dfs(root.right, result);
		}
	}
}
