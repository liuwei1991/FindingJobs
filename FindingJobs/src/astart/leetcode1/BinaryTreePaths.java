package astart.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x; 
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root==null){
			return result;
		}
		String tmp = String.valueOf(root.val);
		this.dfs(root, tmp, result);
		return result;
    }
	
	public void dfs(TreeNode root,String path,List<String> result){
//		String tmp = "->"+String.valueOf(root.val);
		if(root.left==null && root.right==null){
			result.add(path);
			return;
		}
		if(root.left!=null){
			String tmp ="->" + String.valueOf(root.left);
			this.dfs(root.left, path+tmp, result);
		}
		if(root.right!=null){
			String tmp ="->" + String.valueOf(root.right);
			this.dfs(root.right, path+tmp, result);
		}
	}
}
